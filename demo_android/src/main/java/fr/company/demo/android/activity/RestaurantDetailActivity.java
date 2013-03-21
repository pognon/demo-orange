package fr.company.demo.android.activity;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;

import fr.company.demo.android.R;
import fr.company.demo.android.component.TabListener;
import fr.company.demo.android.fragment.RestaurantCarteFragment;
import fr.company.demo.android.fragment.RestaurantDescriptionFragment;
import fr.company.demo.android.util.PropertyManager;

public class RestaurantDetailActivity extends SherlockBaseFragmentActivity{
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		// Load properties
		new PropertyManager(this);
				
		//setContentView(R.layout.restaurant_detail_activity);
		prepareActionBar(bundle);
		   
	}
	
	protected void prepareActionBar(Bundle bundle) 
	{
		
				// setup action bar for tabs
				ActionBar actionBar = getSupportActionBar();
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				actionBar.setDisplayUseLogoEnabled(false);
				actionBar.setDisplayShowTitleEnabled(true);
				actionBar.setDisplayShowHomeEnabled(true);
				actionBar.setDisplayHomeAsUpEnabled(true);

				// Configuration des tabs dans l'actionbar
				ActionBar.Tab tab = actionBar
						.newTab()
						.setText("Description")
						.setTabListener(
								new TabListener<RestaurantDescriptionFragment>(this, "Description",
										RestaurantDescriptionFragment.class))
						.setTag(0);
				actionBar.addTab(tab);

				tab = actionBar
						.newTab()
						.setText("Carte")
						.setTabListener(
								new TabListener<RestaurantCarteFragment>(this, "Carte",
										RestaurantCarteFragment.class))
						.setTag(1);
				actionBar.addTab(tab);
				
				if (bundle != null) {
			        actionBar.setSelectedNavigationItem(bundle.getInt("tab", 0));
			    }
				
	}
	

}
