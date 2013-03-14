package fr.company.demo.android.activity;

import com.actionbarsherlock.app.SherlockFragmentActivity;

import fr.company.demo.android.util.Logger;

import android.os.Bundle;


public class SherlockBaseFragmentActivity extends SherlockFragmentActivity{
	
	
	final String TAG = getClass().getName();
	
	@Override
	protected void onCreate(Bundle arg0) {
		Logger.log(TAG, "onCreate");
		super.onCreate(arg0);
	}
	
	@Override
	protected void onPause() {
		Logger.log(TAG, "onPause");
		super.onPause();
	}
	
	
	@Override
	protected void onResume() {
		Logger.log(TAG, "onResume");
		super.onResume();
	}
	
	@Override
	protected void onRestart() {
		Logger.log(TAG, "onRestart");
		super.onRestart();
	}
	
	@Override
	protected void onDestroy() {
		Logger.log(TAG, "onDestroy");
		super.onDestroy();
	}

}
