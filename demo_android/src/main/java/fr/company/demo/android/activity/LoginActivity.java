package fr.company.demo.android.activity;


import java.io.InputStream;
import java.util.List;

import com.viewpagerindicator.TitlePageIndicator;

import fr.company.demo.android.task.ServerCommandListener;









public class LoginActivity extends /*BaseActivity*/ SherlockBaseActivity implements ServerCommandListener{
	
	final String TAG = getClass().getName();
	
	
	TitlePageIndicator titleIndicator = null;
	

	@Override
	public void requestStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestFinished(List<?> response, String token, Exception error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imageDownloadFinished(InputStream is, String token,
			Exception error) {
		// TODO Auto-generated method stub
		
	}
	
}
