package fr.company.demo.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.viewpagerindicator.TitlePageIndicator;

import fr.company.demo.android.R;

public class RestaurantCarteFragment extends SherlockFragment {

	private static final String[] CONTENT = new String[] { "Entree", "Plat",
			"Dessert", "Menu", "Boisson" };
	private static final int[] ICONS = new int[] {
			R.drawable.ic_action_recherche, R.drawable.ic_action_recherche,
			R.drawable.ic_action_recherche, R.drawable.ic_action_recherche,
			R.drawable.ic_action_recherche };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.restaurant_carte_fragment, container,
				false);
	}
	
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		/*
		FragmentPagerAdapter adapter = new CustomPageAdapter(getActivity()
				.getSupportFragmentManager());
				*/
		
		PagerAdapter adapter = new CustomPageAdapter();

		ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
		pager.setAdapter(adapter);

		TitlePageIndicator indicator = (TitlePageIndicator) view.findViewById(
				R.id.indicator);
		indicator.setViewPager(pager);
		
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
		//mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		MenuItem mnu2 = menu.add(0, 1, 1, "Menu 2");
		mnu2.setAlphabeticShortcut('b');
		//mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

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

	
	/*
	class CustomPageAdapter extends FragmentPagerAdapter implements
			IconPagerAdapter {
		public CustomPageAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {

			//return DefaultFragment.newInstance(CONTENT[position % CONTENT.length]);

			Fragment f = new Fragment();

			switch (position) {
			case 0:
				f = RestaurantCarteEntreeFragment.newInstance();
				break;
			case 1:
				f = RestaurantCartePlatFragment.newInstance();
				break;
			}

			return f;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position % CONTENT.length].toUpperCase();
		}

		@Override
		public int getIconResId(int index) {
			return ICONS[index];
		}

		@Override
		public int getCount() {
			return CONTENT.length;
		}
	}
	
	*/
	
	class CustomPageAdapter extends PagerAdapter  {

		@Override
		public int getCount() {
			return CONTENT.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			 return view == object;
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position % CONTENT.length].toUpperCase();
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			 LayoutInflater inflater = (LayoutInflater) container.getContext()
			            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View view = null;
			
			switch (position) {
			
			case 0:
				view = inflater.inflate(R.layout.layout_entree, null);
				ListView listView = (ListView) view.findViewById(R.id.listView);
				//listView.setOnItemClickListener(new MemberListItemClickListener());
				//listView.setEmptyView(findViewById(R.id.empty));
				break;
				
			case 1:
				view = inflater.inflate(R.layout.layout_plat, null);
				break;
				
			default:
				 view = inflater.inflate(R.layout.layout_plat, null);
				 break;
			
			}
			
			((ViewPager) container).addView(view, 0);

			return view;
		
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((View)object);
		}
		
	}

}
