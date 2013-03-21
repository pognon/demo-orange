package fr.company.demo.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

import fr.company.demo.android.R;
import fr.company.demo.android.util.Logger;

public class RestaurantDescriptionFragment extends SherlockFragment {

	final String TAG = getClass().getName();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.restaurant_description_fragment, container, false);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu,
			com.actionbarsherlock.view.MenuInflater inflater) {
	 createMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return menuChoice(item);
	}

	private void createMenu(Menu menu) {
		
		menu.clear();
		
		
		SubMenu option = menu.addSubMenu(null);
		option.add(0, 0, 0, "Menu 1").setIcon(R.drawable.ic_action_recherche);
		option.add(0, 1, 1, "Menu 2").setIcon(R.drawable.ic_action_recherche);
		
		MenuItem moreButton = option.getItem();
        moreButton.setIcon(R.drawable.ic_action_recherche);
        moreButton.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        
        MenuItem mnu1 = option.getItem(0);
        mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        
      
        MenuItem mnu2 = option.getItem(1);
        mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
      	
		
		/*
		MenuItem mnu1 = menu.add(0, 0, 0, "Menu 1");
		mnu1.setAlphabeticShortcut('a');
		mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		MenuItem mnu2 = menu.add(0, 1, 1, "Menu 2");
		mnu2.setAlphabeticShortcut('b');
		mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		*/
	
		
		

	}

	private boolean menuChoice(MenuItem item) {
		
		Toast.makeText(getActivity(), "MenuChoice..." + item.getItemId(), Toast.LENGTH_LONG).show();
		
		switch (item.getItemId()) {
		case 0:
			Toast.makeText(getActivity(), "xxxxxx", Toast.LENGTH_LONG).show();
			return true;

		case 1:
			return true;

		case 2:
			return true;
		}

		return false;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

}
