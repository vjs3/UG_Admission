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

public class StudentInfoFragment extends Fragment {
    private boolean mSearchCheck;
    //private TextView mTxtDownload;
    public TextView name_of_applicant;
    public TextView date_of_birth;
    public TextView jee_mains_marks;
    public TextView jee_mains_rank;
    public TextView email_id;
    public TextView phone_number;
    public ImageView applicant_photo;
    public String response_server = null;

    // JSON Node names
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_NAME = "name";
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PHONE_MOBILE = "mobile";
    private static final String TAG_JEE_MAINS_MARKS="jee_main_marks";
    private static final String TAG_JEE_MAINS_RANK="jee_main_rank";
    private static final String TAG_DATE_OF_BIRTH = "dob";

    // contacts JSONArray
    JSONObject narwal = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;

    //Progress Dialog
    private ProgressDialog pDialog;

    public static String url_server = "http://192.168.137.81:8000/api/applicant/1/";

    public StudentInfoFragment newInstance(String text){
        StudentInfoFragment mFragment = new StudentInfoFragment();
        Bundle mBundle = new Bundle();
        mBundle.putString(Constant.TEXT_FRAGMENT, text);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_student_info, container, false);

        name_of_applicant=(TextView)rootView.findViewById(R.id.textViewNameOfApplicant);
        date_of_birth=(TextView)rootView.findViewById(R.id.textViewDateOfBirth);
        jee_mains_marks=(TextView)rootView.findViewById(R.id.textViewJeeMainsMarks);
        jee_mains_rank=(TextView)rootView.findViewById(R.id.textViewJeeMainsRank);
        email_id=(TextView)rootView.findViewById(R.id.textViewEmailId);
        phone_number=(TextView)rootView.findViewById(R.id.textViewPhoneNumber);
        applicant_photo=(ImageView)rootView.findViewById(R.id.imageViewApplicantPhoto);

        //new GetContacts().execute();

        rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));
        return rootView;
    }

    /*private class GetContacts extends AsyncTask<Void, Void, Void> {

        private String nameOfApplicant;
        private String dateOfBirth;
        private String jeeMainsMarks;
        private String jeeMainsRank;
        private String emailId;
        private String phoneNumber;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);// not cancelable by BACK Key
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpEntity httpEntity = null;
                HttpResponse httpResponse = null;

                HttpGet httpGet = new HttpGet(url_server);
                httpResponse = httpClient.execute(httpGet);
                httpEntity = httpResponse.getEntity();
                response_server = EntityUtils.toString(httpEntity);

            }catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }

            // setting response into a String variable jsonStr
            String jsonStr = response_server;

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    narwal = jsonObj;

                    // looping through All Contacts
                    for (int i = 0; i < narwal.length(); i++) {
                        JSONObject c = narwal;

                        nameOfApplicant = c.getString(TAG_NAME);
                        emailId = c.getString(TAG_EMAIL);
                        phoneNumber = c.getString(TAG_PHONE_MOBILE);
                        jeeMainsMarks = c.getString(TAG_JEE_MAINS_MARKS);
                        jeeMainsRank=c.getString(TAG_JEE_MAINS_RANK);
                        dateOfBirth=c.getString(TAG_DATE_OF_BIRTH);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
            return null;
        }
        *//*
        public SimpleAdapter (Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to)

        Parameters

        context:    The context where the View associated with this SimpleAdapter is running
        data:       A List of Maps. Each entry in the List corresponds to one row in the list. The Maps contain the data for each row, and should include all the entries specified in "from"
        resource:   Resource identifier of a view layout that defines the views for this list item. The layout file should include at least those named views defined in "to"
        from:       A list of column names that will be added to the Map associated with each item.
        to:         The views that should display column in the "from" parameter. These should all be TextViews. The first N views in this list are given the values of the first N columns in the from parameter.

        *//*
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            *//**
             * Updating parsed JSON data into ListView
             * *//*
            *//*ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this,
                    contactList,
                    R.layout.list_item,
                    new String[] {
                            TAG_NAME,
                            TAG_EMAIL,
                            TAG_PHONE_MOBILE
                    },
                    new int[] {
                            R.id.name,
                            R.id.email,
                            R.id.mobile }
            );

            setListAdapter(adapter);*//*

            name_of_applicant.setText(nameOfApplicant);
            date_of_birth.setText(dateOfBirth);
            jee_mains_marks.setText(jeeMainsMarks);
            jee_mains_rank.setText(jeeMainsRank);
            email_id.setText(emailId);
            phone_number.setText(phoneNumber);
        }

    }*/


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

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(Menus.SEARCH));
        searchView.setQueryHint(this.getString(R.string.search));

        ((EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text))
                .setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(OnQuerySearchView);

        menu.findItem(Menus.ADD).setVisible(true);
        menu.findItem(Menus.UPDATE).setVisible(true);
        menu.findItem(Menus.SEARCH).setVisible(true);

        mSearchCheck = false;
    }

    @Override
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

    private OnQueryTextListener OnQuerySearchView = new OnQueryTextListener() {

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
    };
}
