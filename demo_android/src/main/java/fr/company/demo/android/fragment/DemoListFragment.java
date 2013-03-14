package fr.company.demo.android.fragment;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import fr.company.demo.android.R;
import fr.company.demo.android.activity.MainActivity;
import fr.company.demo.android.util.Logger;


public class DemoListFragment extends SherlockListFragment {

	final String TAG = getClass().getName();

	
	private AsyncTask<String, Void, Void> missionsTask;
	private EncoursListAdapter encoursListAdapter;


	private List<?> missions;
	private List<?> filteredMissions;

	private String sort;
	
	private ProgressDialog asyncTaskDialog;

	
	// Lister that should be implemented by the parent activity for specific task
	// It allows this fragment to call a method from the parent activity.
	// This is used to avoir coupling.
	private EncoursListFragmentListener listener;
	
	public interface EncoursListFragmentListener 
	{	public void doSomething();
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		Logger.log(TAG, "onCreateView" + getTag());
		return inflater.inflate(R.layout.demo_list_fragment, container, false);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	
	public void onListItemClick(ListView parent, View v, int position, long id)
	{
		
	}
	
	
	@Override
	public void onResume() {
		
		super.onResume();
	}

	
	
	

	

	public class CustomCursorAdapter extends SimpleCursorAdapter 
	{
		private int layout;
		private LayoutInflater inflater;

		public CustomCursorAdapter(Context context, int layout, Cursor c,
				String[] from, int[] to, int flag) 
		{
			super(context, layout, c, from, to, flag);
			this.layout = layout;

			inflater = LayoutInflater.from(mContext);
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) 
		{
			return null;
		}

		@Override
		public void bindView(View convertView, Context context, Cursor c) 
		{
			
		}
	}

	public class EncoursListAdapter extends BaseAdapter 
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	// Custom ViewHolder for list item reusability
	public static class ViewHolder 
	{
		// Used for mission list properties
		public TextView numMis2000TextView;
		public TextView immaTextView;
		public TextView nombrePhotoTextView;
	}

	private class MissionsListItemClickListener implements OnItemClickListener 
	{
		@Override
		public void onItemClick(AdapterView parent, View v, int position, long id) 
		{
		}
	}

	/**
	 * Custom class for mission retrieval
	 */
	private class MissionRetrieverTask extends AsyncTask<String, Void, Void> 
	{
		private Activity activity;

		private String content;
		private String Error = null;

		private String caller;
		private boolean dismissDialog;
		
		//private ProgressDialog asyncTaskDialog;

		MissionRetrieverTask(Activity activity, boolean dismissDialog) 
		{
			this.activity = activity;
			this.dismissDialog = dismissDialog;
			if (asyncTaskDialog == null) 
			{
				asyncTaskDialog = new ProgressDialog(activity);
			}
		}

		@Override
		protected void onPreExecute() 
		{
			
			super.onPreExecute();
			
		}

		@Override
		protected Void doInBackground(String... urls) 
		{
			try {

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				Error = e.getMessage();
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void unused) 
		{
			Logger.log(TAG, "onPostExecute...." );
			
			super.onPostExecute(unused);
			
			//handleResponse(content, caller);
			
			if (asyncTaskDialog!=null && asyncTaskDialog.isShowing()) 
			{
				asyncTaskDialog.dismiss();
			}
			if (Error != null) 
			{
				
				Logger.log(TAG, "Found an error....");
				
			} else {
				handleResponse(content, caller);
			}
			
		}

		// Generic callback method
		public void handleResponse(String response, String caller) 
		{

			Logger.log(TAG, "handleResponse....");
			
		}

	}

	
	@Override
	public void onCreateOptionsMenu(Menu menu,
			com.actionbarsherlock.view.MenuInflater inflater) {
	 createMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		return menuChoice(item);
	}

	private void createMenu(Menu menu) 
	{
		menu.clear();
		
		MenuItem mnu1 = menu.add(0, 0, 0, "Rechercher");
		mnu1.setAlphabeticShortcut('r');
		mnu1.setIcon(R.drawable.ic_action_recherche);
		mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
				| MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

		SearchView searchView = new SearchView(getActivity());
		mnu1.setActionView(searchView);
		
		searchView.setOnQueryTextListener(new CustomQueryTextAdapter(this.getActivity()));
		searchView.setOnCloseListener(new CustomCloseAdapter(this.getActivity()));
		
	}

	private boolean menuChoice(MenuItem item) 
	{
		switch (item.getItemId()) {
		
		case android.R.id.home:
			// Retour au menu de l'application
			Intent intent = new Intent(getActivity().getBaseContext(),MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
            
		case 0:
			Toast.makeText(getActivity(), "Rechercher", Toast.LENGTH_LONG).show();
			return true;
		}

		return false;
	
	}

	
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) 
	{
	}
	
	
	@Override
	public void onSaveInstanceState(Bundle outState) 
	{
		super.onSaveInstanceState(outState);
	}

	public void updateFragmentContent(String string) 
	{
		Logger.log(TAG, "updateFragmentContent....");
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		Logger.log(TAG, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}
	
	@SuppressWarnings("unused")
	private class SearchBoxTextWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable arg0) {

		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int end) {
			// Update and refresh members listview
		}

	}

	
	public class CustomQueryTextAdapter implements SearchView.OnQueryTextListener
	{
		private Activity activity;

		CustomQueryTextAdapter(Activity activity) {
			this.activity = activity;
		}
		
		@Override
		public boolean onQueryTextChange(String arg0) {
			return false;
		}

		@Override
		public boolean onQueryTextSubmit(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}		
	}

	public class CustomCloseAdapter implements SearchView.OnCloseListener
	{	
		@SuppressWarnings("unused")
		private Activity activity;

		CustomCloseAdapter(Activity activity) {
			this.activity = activity;
		}

		@Override
		public boolean onClose() {
			// TODO Auto-generated method stub
			return false;
		}
	}
	

}
