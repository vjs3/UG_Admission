package com.vishwajeets3.loginregistration.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;

import com.vishwajeets3.loginregistration.R;
import com.vishwajeets3.loginregistration.utils.Constant;

import static com.vishwajeets3.loginregistration.utils.Menus.*;

public class RouteFragment extends Fragment {

    private TextView mTxtRoute;
    private boolean mSearchCheck;

    public RouteFragment newInstance(String text) {
        RouteFragment mFragment = new RouteFragment();
        Bundle mBundle = new Bundle();
        mBundle.putString(Constant.TEXT_FRAGMENT, text);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View rootView = inflater.inflate(R.layout.route_fragment, container, false);

        mTxtRoute = (TextView) rootView.findViewById(R.id.txtRoute);
        mTxtRoute.setText(getArguments().getString(Constant.TEXT_FRAGMENT));

        rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
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

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(SEARCH));
        searchView.setQueryHint(this.getString(R.string.search));

        ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text))
                .setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(OnQuerySearchView);

        menu.findItem(ADD).setVisible(true);
        menu.findItem(UPDATE).setVisible(false);
        menu.findItem(SEARCH).setVisible(true);

        mSearchCheck = false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        switch (item.getItemId()) {

            case ADD:
                break;

            case UPDATE:
                break;

            case SEARCH:
                mSearchCheck = true;
                break;
        }
        return true;
    }

    private OnQueryTextListener OnQuerySearchView = new OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String arg0) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean onQueryTextChange(String arg0) {
            // TODO Auto-generated method stub
            if (mSearchCheck) {
                // implement your search here
            }
            return false;
        }
    };
}
