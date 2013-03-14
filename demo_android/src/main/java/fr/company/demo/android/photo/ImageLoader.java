package fr.company.demo.android.photo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import fr.company.demo.android.R;
import fr.company.demo.android.util.AppUtils;
import fr.company.demo.android.util.PropertyManager;
import fr.company.demo.android.util.Sha1Utils;


public class ImageLoader {
    
    MemoryCache memoryCache=new MemoryCache();
    FileCache fileCache;
    private Map<ImageView, String> imageViews=Collections.synchronizedMap(new WeakHashMap<ImageView, String>());
    ExecutorService executorService; 
    
    private SharedPreferences myprefs;
    
    public ImageLoader(Context context){
        fileCache=new FileCache(context);
        executorService=Executors.newFixedThreadPool(5);
    }
    
    final int stub_id = R.drawable.no_image;
    public void DisplayImage(String url, ImageView imageView)
    {
        imageViews.put(imageView, url);
        Bitmap bitmap=memoryCache.get(url);
        if(bitmap!=null){
        	
            imageView.setImageBitmap(bitmap);
        }
        else
        {
            queuePhoto(url, imageView);
            imageView.setImageResource(stub_id);
        }
    }
        
    private void queuePhoto(String url, ImageView imageView)
    {
        PhotoToLoad p=new PhotoToLoad(url, imageView);
        executorService.submit(new PhotosLoader(p));
    }
    
 
	private Bitmap getBitmap(String url) 
    {
        File f=fileCache.getFile(url);
        
        //from SD cache
        Bitmap b = decodeFile(f);
        if(b!=null)
            return b;
        
        //from web
        try {
        	
        	final HttpPost httpPost = new HttpPost(url);
        	final HttpClient client = new DefaultHttpClient() ;
        	
        	String timestamp = System.currentTimeMillis() + "";
			String hash = Sha1Utils.sha(PropertyManager.getWSCallerSecret()
					+ timestamp);

			String wsCallerId = PropertyManager.getWSCallerId();

			String data = buildRequestData(wsCallerId, hash, timestamp);

			
			StringEntity bodyEntity = new StringEntity(data);
			bodyEntity.setChunked(false);
			httpPost.setEntity(bodyEntity);

			httpPost.setHeader("Content-Type", "application/json");
			// httpPost.setHeader("Accept-Encoding", "gzip");

			// Append the user SessionToken if any.

			/*
			myprefs = PreferenceManager.getDefaultSharedPreferences();
			String sessionToken = myprefs.getString("sessionToken", "");

			httpPost.setHeader("Authorization", sessionToken);
			*/
			
            HttpResponse response = client.execute(httpPost);
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.w("ImageDownloader", "Error " + statusCode +
                        " while retrieving bitmap from " + url);
                return null;
            }

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = null;
                Bitmap bitmap=null;
                try {
                    inputStream = entity.getContent();
                    // return BitmapFactory.decodeStream(inputStream);
                    // Bug on slow connections, fixed in future release.
                    OutputStream os = new FileOutputStream(f);
                    AppUtils.CopyStream(inputStream, os);
                    os.close();
                    bitmap = decodeFile(f);
                    return bitmap;
                    
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }
            }
        	
        	
        } catch (Exception ex){
           ex.printStackTrace();
           return null;
        }
        
        return null;
    }

    //decodes image and scales it to reduce memory consumption
    private Bitmap decodeFile(File f){
        try {
            //decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f),null,o);
            
            //Find the correct scale value. It should be the power of 2.
            final int REQUIRED_SIZE=70;
            int width_tmp=o.outWidth, height_tmp=o.outHeight;
            int scale=1;
            while(true){
                if(width_tmp/2<REQUIRED_SIZE || height_tmp/2<REQUIRED_SIZE)
                    break;
                width_tmp/=2;
                height_tmp/=2;
                scale*=2;
            }
            
            //decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize=scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {}
        return null;
    }
    
    //Task for the queue
    private class PhotoToLoad
    {
        public String url;
        public ImageView imageView;
        public PhotoToLoad(String u, ImageView i){
            url=u; 
            imageView=i;
        }
    }
    
    class PhotosLoader implements Runnable {
        PhotoToLoad photoToLoad;
        PhotosLoader(PhotoToLoad photoToLoad){
            this.photoToLoad=photoToLoad;
        }
      
        public void run() {
            if(imageViewReused(photoToLoad))
                return;
            Bitmap bmp=getBitmap(photoToLoad.url);
            memoryCache.put(photoToLoad.url, bmp);
            if(imageViewReused(photoToLoad))
                return;
            BitmapDisplayer bd=new BitmapDisplayer(bmp, photoToLoad);
            Activity a=(Activity)photoToLoad.imageView.getContext();
            a.runOnUiThread(bd);
        }
    }
    
    boolean imageViewReused(PhotoToLoad photoToLoad){
        String tag=imageViews.get(photoToLoad.imageView);
        if(tag==null || !tag.equals(photoToLoad.url))
            return true;
        return false;
    }
    
    //Used to display bitmap in the UI thread
    class BitmapDisplayer implements Runnable
    {
        Bitmap bitmap;
        PhotoToLoad photoToLoad;
        public BitmapDisplayer(Bitmap b, PhotoToLoad p){bitmap=b;photoToLoad=p;}
        public void run()
        {
            if(imageViewReused(photoToLoad))
                return;
            if(bitmap!=null)
                photoToLoad.imageView.setImageBitmap(bitmap);
            else
                photoToLoad.imageView.setImageResource(stub_id);
        }
    }

    public void clearCache() {
        memoryCache.clear();
        fileCache.clear();
    }
    
    
    public void clearItemFromCache(String key){
    	
    	memoryCache.clearItem(key);
    	fileCache.clearItem(key);
    }
    
    public String buildRequestData(String wsCallerId, String hash,
			String timestamp) throws Exception {

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

}
