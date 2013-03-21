package fr.company.demo.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import fr.company.demo.android.R;

public class DemoFragment extends SherlockFragment {

	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.demo_fragment, container, false);
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

		MenuItem mnu1 = menu.add(0, 0, 0, "Menu 1");
		mnu1.setAlphabeticShortcut('a');
		mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		MenuItem mnu2 = menu.add(0, 1, 1, "Menu 2");
		mnu2.setAlphabeticShortcut('b');
		mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

	}

	private boolean menuChoice(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
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
