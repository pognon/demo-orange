package fr.company.demo.android.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import fr.company.demo.android.R;
import fr.company.demo.android.photo.ImageLoader;


public class DashboardActivity extends SherlockBaseActivity{
	
	final String TAG = getClass().getName();
	
	private GridView gridView;
	public enum NAMES {TRANSACTIONS, COUPONS, CREDIT_CARDS, OTHERS;};
	static final String[] IMAGE_NAMES = new String[] { NAMES.TRANSACTIONS.name(), NAMES.COUPONS.name(), NAMES.CREDIT_CARDS.name(), NAMES.OTHERS.name() };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.dashboard_activity);
		
		gridView = (GridView) findViewById(R.id.gridView1);
		 
		gridView.setAdapter(new GridViewItemAdapter(IMAGE_NAMES));
 
		gridView.setOnItemClickListener(new GridViewItemClickListener());
		
	}
	
	
	
	
	
	private class GridViewItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {

			Intent intent = new Intent(DashboardActivity.this, RestaurantListActivity.class);
			startActivity(intent);

		}

	}
	
	

	public class GridViewItemAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		private String[] mData;

		public GridViewItemAdapter(String[] data) {
			if (data != null) {
				mData = data;
			}
			inflater = LayoutInflater.from(DashboardActivity.this);
		}

		public int getCount() {
			return mData.length;
		}

		public Object getItem(int position) {
			Object retval = mData[position];
			return retval;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			String item = mData[position];
			ViewHolder holder = null;
			View v = convertView;

			if (v == null) {
				
				v = inflater.inflate(R.layout.dashboard_activity_gridview_item,null);
				holder = new ViewHolder();
				
				holder.imageView = (ImageView) v.findViewById(R.id.grid_item_image);
				
				
				if (item.equals(NAMES.TRANSACTIONS.name())) {
					holder.imageView.setImageResource(R.drawable.no_image);
				} else if (item.equals(NAMES.COUPONS.name())) {
					holder.imageView.setImageResource(R.drawable.no_image);
				} else if (item.equals(NAMES.CREDIT_CARDS.name())) {
					holder.imageView.setImageResource(R.drawable.no_image);
				} else {
					holder.imageView.setImageResource(R.drawable.no_image);
				}
				
				
				v.setTag(holder);
				
			} else {
				holder = (ViewHolder) v.getTag();
			}

			return v;
		}

		public String[] getmData() {
			return mData;
		}

		public void setmData(String[] mData) {
			this.mData = mData;
		}

	}

	// Custom ViewHolder for list item reusability
	public static class ViewHolder {
		public ImageView imageView;
	}
	

}
