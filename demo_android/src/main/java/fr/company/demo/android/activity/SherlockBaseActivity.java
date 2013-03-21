package fr.company.demo.android.activity;

import android.app.ActivityManager;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;


public abstract class SherlockBaseActivity extends SherlockActivity {
	
	public ActivityManager activityManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		activityManager = (ActivityManager) this.getSystemService( ACTIVITY_SERVICE );
	}
	
	
	
}
