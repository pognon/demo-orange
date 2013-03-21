package fr.company.demo.android.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import fr.company.demo.android.R;
import fr.company.demo.android.model.Restaurant;
import fr.company.demo.android.photo.ImageLoader;

public class RestaurantListActivity extends SherlockBaseActivity{
	
	final String TAG = getClass().getName();
	
	private List<Restaurant> restaurants;
	private Restaurant restaurant = null;
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.restaurant_list_activity);
		
		listView = (ListView) findViewById(R.id.listView);
		
		listView.setOnItemClickListener(new RestaurantListItemClickListener());
		
		listView.setEmptyView(findViewById(R.id.empty));
		
		
		// Retreive restaurants
		
		listView.setAdapter(new RestaurantListAdapter(restaurants));

		
	}
	
	
	public class RestaurantListAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		private List<Restaurant> mData = new ArrayList<Restaurant>();
		private ImageLoader imageLoader = null;


		public RestaurantListAdapter(List<Restaurant> data) {
			if (data != null) {
				mData = data;
			}
			inflater = LayoutInflater.from(RestaurantListActivity.this);
			imageLoader=new ImageLoader(RestaurantListActivity.this);
		}

		public int getCount() {
			return mData.size();
		}

		public Object getItem(int position) {
			Object retval = mData.get(position);
			return retval;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			Restaurant restaurant = mData.get(position);
			ViewHolder holder = null;
			View v = convertView;

			if (v == null) {
				
				v = inflater.inflate(R.layout.restaurant_list_activity_cell,null);
				holder = new ViewHolder();

				holder.fullName = (TextView) v.findViewById(R.id.userFullName);
				holder.imageView = (ImageView) v.findViewById(R.id.userImage);
				
				/*
				imageLoader.DisplayImage(restaurant.getPhotoURL(), holder.imageView);
				holder.fullName.setText(restaurant.getPrenom() + " " + restaurant.getNom());
				*/
				
				v.setTag(holder);
				
			} else {
				holder = (ViewHolder) v.getTag();
			}

			return v;
		}

		public List<Restaurant> getmData() {
			return mData;
		}

		public void setmData(List<Restaurant> mData) {
			this.mData = mData;
		}
	}

	// Custom ViewHolder for list item reusability
	public static class ViewHolder {
		public ImageView imageView;
		public TextView fullName;
	}
	
	
	private class RestaurantListItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {

			Intent intent = new Intent(RestaurantListActivity.this,
					RestaurantDetailActivity.class);
			startActivity(intent);

		}
	}

}
