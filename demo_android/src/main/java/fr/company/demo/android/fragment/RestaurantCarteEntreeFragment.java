package fr.company.demo.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

import fr.company.demo.android.R;

public class RestaurantCarteEntreeFragment extends SherlockFragment {



	  public static Fragment newInstance() {
		RestaurantCarteEntreeFragment f = new RestaurantCarteEntreeFragment();
 
        return f;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_entree, null);
        return root;
    }
  
}
