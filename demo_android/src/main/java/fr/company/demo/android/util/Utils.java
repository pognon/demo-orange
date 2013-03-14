package fr.company.demo.android.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Base64;
import android.util.Log;

public class Utils {
	
	
	final String TAG = getClass().getName();

	
	/**
	 * @param context
	 * @param object
	 * @param key
	 * @return
	 */
	public static boolean putInCache(Context context, Object object, String key) {

		boolean succes = false;
		FileOutputStream fos;
		ObjectOutputStream objectOutStream = null;
		try {
			fos = context.openFileOutput(key, Context.MODE_PRIVATE);
			objectOutStream = new ObjectOutputStream(fos);
			objectOutStream.writeObject(object);
			succes = true;
		} catch (FileNotFoundException e) {
			Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
		} catch (IOException e) {
			Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
		} finally {
			try {
				objectOutStream.close();
			} catch (IOException e) {
				Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
			}
		}
		return succes;
	}

	/**
	 * Permet de savoir si le cache a été créé ou non
	 * 
	 * @param context
	 * @return
	 */
	public static boolean hasCache(Context context, String key) {

		boolean hasCache = false;

		ObjectInputStream objectInStream = null;
		try {
			// tentative de recuperation des items dans le cache :
			Object inStream = context.openFileInput(key);
			if (inStream != null) {
				hasCache = true;
			}
		} catch (FileNotFoundException e) {
			Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
		} finally {
			try {
				if (objectInStream != null) {
					objectInStream.close();
				}
			} catch (IOException e) {
				Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
			}
		}
		return hasCache;
	}

	/**
	 * @param context
	 * @param key
	 * @return
	 */
	public static Object getFromCache(Context context, String key) {

		FileInputStream inStream;
		ObjectInputStream objectInStream = null;
		Object readObject = null;
		try {
			// tentative de recuperation des items dans le cache :
			inStream = context.openFileInput(key);
			if (inStream != null) {
				objectInStream = new ObjectInputStream(inStream);
				readObject = objectInStream.readObject();
			}
		} catch (FileNotFoundException e) {
			Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
		} catch (StreamCorruptedException e) {
			Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
		} catch (IOException e) {
			Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
		} catch (ClassNotFoundException e) {
			Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
		} finally {
			try {
				if (objectInStream != null) {
					objectInStream.close();
				}
			} catch (IOException e) {
				Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
			}
		}
		return readObject;
	}

	/**
	 * Supprime du cache pour la cle 'key'
	 * 
	 * @param applicationContext
	 * @param key
	 */
	public static void deleteFromCache(Context applicationContext, String key) {
		FileInputStream inStream = null;
		try {
			inStream = applicationContext.openFileInput(key);
		} catch (FileNotFoundException e) {
			Log.e(Context.ACTIVITY_SERVICE, e.getMessage());
		}
		if (inStream != null) {
			boolean isSucces = applicationContext.deleteFile(key);
			// if (Log.isLoggable(null, Log.DEBUG)) {
			if (isSucces) {
				Log.d(null, "image cache for " + key + " is successfully deleted");
			} else {
				Log.d(null, "error while deleting cache for " + key);
			}
			// }
		}
	}
	
	
	
	
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		final float roundPx = 5;

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}
	
	public static String convertBitmapToString(Bitmap src) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		src.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, (OutputStream) os);
		//return os.toString();
		//return Base64.encode(os.toByteArray());
		
		return Base64.encodeToString(os.toByteArray(), Base64.DEFAULT);
	}

}
