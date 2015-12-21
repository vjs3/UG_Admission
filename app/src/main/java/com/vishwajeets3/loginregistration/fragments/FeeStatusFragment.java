package com.vishwajeets3.loginregistration.fragments;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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

public class FeeStatusFragment extends Fragment {
    private boolean mSearchCheck;
    private TextView fee_submission_date;
    private ImageView download_button;
    private ImageView call_button;
    public String response_server = null;
    // JSON Node names
    private static final String TAG_NAME = "name";
    // contacts JSONArray
    JSONObject narwal = null;
    //Progress Dialog
    private ProgressDialog pDialog;
    public static String url_server = "http://192.168.0.107:8000/api/applicant/1/";

    public FeeStatusFragment newInstance(String text){
        FeeStatusFragment mFragment = new FeeStatusFragment();
        Bundle mBundle = new Bundle();
        mBundle.putString(Constant.TEXT_FRAGMENT, text);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fee_status, container, false);
        fee_submission_date = (TextView) rootView.findViewById(R.id.textViewFeeSubmissionDate_feeStatus);
        download_button = (ImageView) rootView.findViewById(R.id.imageViewDownloadButton_feeStatus);
        call_button=(ImageView) rootView.findViewById(R.id.imageViewCallButton_feeStatus);
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number="7742173669";
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));
                startActivity(callIntent);
            }
        });
        new GetContacts().execute();
        rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));
        return rootView;
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        private String nameOfApplicant;

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

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
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

                        //Storing the response parameters into corresponding variables so that they can be set to their respective views
                        nameOfApplicant = c.getString(TAG_NAME);

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

        /*
        public SimpleAdapter (Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to)

        Parameters

        context:    The context where the View associated with this SimpleAdapter is running
        data:       A List of Maps. Each entry in the List corresponds to one row in the list. The Maps contain the data for each row, and should include all the entries specified in "from"
        resource:   Resource identifier of a view layout that defines the views for this list item. The layout file should include at least those named views defined in "to"
        from:       A list of column names that will be added to the Map associated with each item.
        to:         The views that should display column in the "from" parameter. These should all be TextViews. The first N views in this list are given the values of the first N columns in the from parameter.

        */
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            /*ListAdapter adapter = new SimpleAdapter(
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

            setListAdapter(adapter);*/

            //setting the information from strings to Views in the XML Layout
            //name_of_applicant.setText(nameOfApplicant);
        }
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
