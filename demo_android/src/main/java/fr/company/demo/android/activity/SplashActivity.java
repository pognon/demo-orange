package fr.company.demo.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.actionbarsherlock.view.Window;

import fr.company.demo.android.R;
import fr.company.demo.android.communication.GenericRunnable;
import fr.company.demo.android.util.PropertyManager;

public class SplashActivity extends SherlockBaseActivity {

	final String TAG = getClass().getName();
	private boolean imageChoiceStatus = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.splash_activity);

		// Load properties
		new PropertyManager(this);

		final ImageView splash = (ImageView) findViewById(R.id.imageViewSplash);
		/*
		 * New Handler to start the new Activity and close this Splash-Screen
		 * after some seconds.
		 */
		final Handler uiThreadCallback = new Handler();

		final GenericRunnable runInUIThread = new GenericRunnable() {
			public void run() {
				if (imageChoiceStatus) {
					splash.setImageResource(R.drawable.splash1);
				} else {
					splash.setImageResource(R.drawable.splash2);
					imageChoiceStatus = true;
				}
			}
		};

		new Thread() {
			public void run() {
				try {

					Thread.sleep(2000);
					uiThreadCallback.post(runInUIThread);
					Thread.sleep(1000);
					uiThreadCallback.post(runInUIThread);
					Thread.sleep(2000);

					Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intent);
					finish();

				} catch (InterruptedException e) {
				}
			}

		}.start();

	}

}
