package fr.company.demo.android.task;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import fr.company.demo.android.util.Logger;
import fr.company.demo.android.util.PropertyManager;
import fr.company.demo.android.util.Sha1Utils;
import fr.company.demo.android.util.Utils;


public class GenericServerCommand extends AsyncTask<String, Void, Void> {

	final String TAG = getClass().getName();

	public String fileName;
	String mockFileName;
	String objectKey;
	public String token;
	String url;
	String commandToken;

	Boolean shouldPersistResponse;

	Context activity;

	public ServerCommandListener listener;

	private final DefaultHttpClient client = new DefaultHttpClient();
	private String content;
	public Exception error = null;

	private SharedPreferences myprefs;

	public GenericServerCommand(Context activity, String commandToken) {
		this.activity = activity;
	}

	public void run() {

		Logger.log(TAG, " GenericServerCommand...");

		execute();
	}

	public ServerCommandListener getListener() {
		return listener;
	}

	public void setListener(ServerCommandListener listener) {
		this.listener = listener;
	}

	@Override
	protected Void doInBackground(String... params) {

		Logger.log(TAG, "doInBackground..." + url);

		try {

			if (PropertyManager.isMockEnabled()) {
				List<?> response = retrieveDataFromCache();
				Logger.log(TAG, "Response from  retrieveDataFromCache : "
						+ response.size() + ":" + response.toString());
				listener.requestFinished(response, token, error);
				// cancel(false);
			}

			else {
				// Do a remote http request from server

				String timestamp = System.currentTimeMillis() + "";
				String hash = Sha1Utils.sha(PropertyManager.getWSCallerSecret()
						+ timestamp);

				String wsCallerId = PropertyManager.getWSCallerId();

				String data = buildRequestData(wsCallerId, hash, timestamp);

				Logger.log(TAG, "RequestData..." + data);

				HttpPost httpPost = new HttpPost(url);
				ResponseHandler<String> responseHandler = new BasicResponseHandler();

				StringEntity entity = new StringEntity(data);
				entity.setChunked(false);
				httpPost.setEntity(entity);

				httpPost.setHeader("Content-Type", "application/json");
				// httpPost.setHeader("Accept-Encoding", "gzip");

				// Append the user SessionToken if any.

				myprefs = PreferenceManager
						.getDefaultSharedPreferences(activity);
				String sessionToken = myprefs.getString("sessionToken", "");

				httpPost.setHeader("Authorization", sessionToken);

				content = client.execute(httpPost, responseHandler);
			}

		} catch (Exception e) {
			cancel(false);
			// e.printStackTrace();
			listener.requestFinished(null, token, e);
			error = e;

		}

		return null;
	}

	public String buildRequestData(String wsCallerId, String hash,
			String timestamp) throws Exception {

		Logger.log(TAG, "buildRequestData...");

		StringBuilder sb = new StringBuilder();
		sb.append("{");

		sb.append("\"wsCallerId\":\"");
		sb.append(wsCallerId).append("\", ");

		sb.append("\"timestamp\":\"");
		sb.append(timestamp).append("\", ");

		sb.append("\"hash\":\"");
		sb.append(hash).append("\"");

		sb.append("}");

		return sb.toString();

	}

	@Override
	protected void onPreExecute() {
		Logger.log(TAG, "onPreExecute...");
		listener.requestStarted();
	}

	@Override
	protected void onPostExecute(Void result) {

		Logger.log(TAG, "onPostExecute..." + content);

		List<?> response = null;

		try {

			if (PropertyManager.isMockEnabled()) {
				// do nothing
			}

			else {

				if (content != null && !content.equals("null")) {

					if (objectKey != null) {

						String data = (new JSONObject(content))
								.getString(objectKey);
						response = parseData(data);

					} else {

						response = parseData(content);

					}

					Logger.log(TAG, "The response is : " + response.toString()
							+ " and the size is : " + response.size());

					if (shouldPersistResponse) {

						persist(content);

						// Save the persistance date in SharedPreference

						myprefs = PreferenceManager
								.getDefaultSharedPreferences(activity);

						android.content.SharedPreferences.Editor e = myprefs
								.edit();
						e.putString(token, System.currentTimeMillis() + "");
						e.commit();

					}

				}

				listener.requestFinished(response, token, error);
			}

		} catch (Exception e) {
			e.printStackTrace();

			listener.requestFinished(response, token, error);
		}
	}

	private void persist(final String data) {

		Logger.log(TAG, "persist...");

		// create how must put in cache
		new Thread(new Runnable() {
			public void run() {
				// save in cache users list :
				if (data != null)
					Utils.putInCache(activity, data, fileName);
			}
		}).start();
	}

	public List<?> parseData(String data) {
		// Should be implemented by child class
		return null;
	}

	public List<?> retrieveDataFromCache() throws Exception {

		Logger.log(TAG, "retrieveDataFromCache...");

		List<?> response = null;
		String cachedData = null;

		if (PropertyManager.isMockEnabled()) {

			InputStream is = activity.getAssets().open(mockFileName);
			InputStreamReader isr = new InputStreamReader(is);

			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(isr);

			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}

			cachedData = sb.toString();

		} else {

			Object object = Utils.getFromCache(activity, mockFileName);
			cachedData = (String) object;

		}

		Logger.log(TAG, "CachedData : " + cachedData);

		if (objectKey != null) {

			String data = (new JSONObject(cachedData)).getString(objectKey);
			response = parseData(data);

		} else {

			response = parseData(cachedData);

		}

		return response;
	}
}
