package com.vishwajeets3.loginregistration.fragments;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vishwajeets3.loginregistration.R;
import com.vishwajeets3.loginregistration.utils.Constant;
import com.vishwajeets3.loginregistration.utils.Menus;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class CounsellingStatusFragment extends Fragment {

    //private boolean mSearchCheck;
    //private TextView mTxtDownload;
    public TextView name_of_applicant;
    public TextView application_id;
    private TextView cell_11,cell_12,cell_13,cell_21,cell_22,cell_23,cell_31,cell_32,cell_33;
    private TextView updates;

    public CounsellingStatusFragment newInstance(String text){
        CounsellingStatusFragment mFragment = new CounsellingStatusFragment();
        Bundle mBundle = new Bundle();
        mBundle.putString(Constant.TEXT_FRAGMENT, text);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View rootView = inflater.inflate(R.layout.fragment_counselling_status, container, false);

        name_of_applicant=(TextView) rootView.findViewById(R.id.textViewNameOfApplicant);
        application_id=(TextView) rootView.findViewById(R.id.textViewApplicationId);
        cell_11=(TextView) rootView.findViewById(R.id.cell_11);
        cell_12=(TextView) rootView.findViewById(R.id.cell_12);
        cell_13=(TextView) rootView.findViewById(R.id.cell_13);
        cell_21=(TextView) rootView.findViewById(R.id.cell_21);
        cell_22=(TextView) rootView.findViewById(R.id.cell_22);
        cell_23=(TextView) rootView.findViewById(R.id.cell_23);
        cell_31=(TextView) rootView.findViewById(R.id.cell_31);
        cell_32=(TextView) rootView.findViewById(R.id.cell_32);
        cell_33=(TextView) rootView.findViewById(R.id.cell_33);
        updates=(TextView) rootView.findViewById(R.id.textViewUpdates_counsellingStatus);

        rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));
        return rootView;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);

        /*SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(Menus.SEARCH));
        searchView.setQueryHint(this.getString(R.string.search));

        ((EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text))
                .setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(OnQuerySearchView);*/

        menu.findItem(Menus.ADD).setVisible(true);
        menu.findItem(Menus.UPDATE).setVisible(true);
        menu.findItem(Menus.SEARCH).setVisible(true);

        //mSearchCheck = false;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        switch (item.getItemId()) {

            case Menus.ADD:
                break;

            case Menus.UPDATE:
                break;

            case Menus.SEARCH:
                mSearchCheck = true;
                break;
        }
        return true;
    }
*/
    /*private OnQueryTextListener OnQuerySearchView = new OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String arg0) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean onQueryTextChange(String arg0) {
            // TODO Auto-generated method stub
            if (mSearchCheck){
                // implement your search here
            }
            return false;
        }
    };*/
}
