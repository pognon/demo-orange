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
import android.widget.Toast;
import fr.company.demo.android.R;
import fr.company.demo.android.listener.OnSwipeTouchListener;
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
		
		
		restaurants = new ArrayList<Restaurant>();
		
		Restaurant resto1 = new Restaurant();
		resto1.setName("resto1");
		
		Restaurant resto2 = new Restaurant();
		resto2.setName("resto2");
		
		restaurants.add(resto1);
		restaurants.add(resto2);
		
		
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

				holder.name = (TextView) v.findViewById(R.id.userFullName);
				holder.imageView = (ImageView) v.findViewById(R.id.userImage);
				
				
				//imageLoader.DisplayImage(restaurant.getName(), holder.imageView);
				holder.name.setText(restaurant.getName());
				
				
				v.setTag(holder);
				
				// set the swipe listener
				v.setOnTouchListener(new OnSwipeTouchListener() {
				    public void onSwipeTop() {
				        Toast.makeText(RestaurantListActivity.this, "top", Toast.LENGTH_SHORT).show();
				    }
				    public void onSwipeRight() {
				        Toast.makeText(RestaurantListActivity.this, "right", Toast.LENGTH_SHORT).show();
				    }
				    public void onSwipeLeft() {
				        Toast.makeText(RestaurantListActivity.this, "left", Toast.LENGTH_SHORT).show();
				    }
				    public void onSwipeBottom() {
				        Toast.makeText(RestaurantListActivity.this, "bottom", Toast.LENGTH_SHORT).show();
				    }
				});
				
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
		public TextView name;
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
