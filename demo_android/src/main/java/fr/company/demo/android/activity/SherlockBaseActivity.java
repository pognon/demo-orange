package fr.company.demo.android.activity;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.ActivityManager;
import android.os.Bundle;


public abstract class SherlockBaseActivity extends SherlockActivity {
	
	public ActivityManager activityManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//ABZ1 24/09/2012
		activityManager = (ActivityManager) this.getSystemService( ACTIVITY_SERVICE );
	}
	
	
	
}
