package com.vishwajeets3.loginregistration.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.vishwajeets3.loginregistration.MainActivity;
import com.vishwajeets3.loginregistration.R;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenAdminActivity extends AppCompatActivity {

    private Button btnDate;
    private Button btnViewStatus;
    //  private EditText etRoundNo;
    private Spinner spinnerRoundNo;
    private Spinner spinner1RoundNo;
    List<String> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_admin);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);


        btnDate = (Button) findViewById(R.id.btnConductRound);
        spinnerRoundNo = (Spinner) findViewById(R.id.spinner);
        /*spinner1RoundNo = (Spinner) findViewById(R.id.spinner1);*/
        //    etRoundNo = (EditText) findViewById(R.id.editText);
        btnViewStatus = (Button) findViewById(R.id.btnCounsellingStatus);

        list = new ArrayList<String>();
        list.add("select");
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");

        ArrayAdapter<String> adp = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list);
        //adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerRoundNo.setAdapter(adp);
        spinner1RoundNo.setAdapter(adp);

        btnViewStatus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //           String roundNo = etRoundNo.getText().toString().trim();
                String roundNo = spinnerRoundNo.getSelectedItem().toString().trim();

                // Check for empty data in the form
                if (!roundNo.equalsIgnoreCase("Select")) {
                    int rno = Integer.parseInt(roundNo);
                    boolean check = checkRound(rno);
                    if(check)
                    {
                        Intent i = new Intent(getApplicationContext(),
                                RoundStatusActivity.class);
                        startActivity(i);

                    } else{
                        Toast.makeText(getApplicationContext(),
                                "Round not Conducted yet!", Toast.LENGTH_LONG)
                                .show();
                    }

                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please select a Round No.!", Toast.LENGTH_LONG)
                            .show();
                }

            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String roundNo = spinner1RoundNo.getSelectedItem().toString().trim();

                // Check for empty data in the form
                if (!roundNo.equalsIgnoreCase("Select")) {
                    int rno = Integer.parseInt(roundNo);
                    boolean check = checkRound(rno);
                    boolean checkPrev = checkRound(rno - 1);
                    if((!check) && (checkPrev))
                    {
                        Intent intent = new Intent(getApplicationContext(),
                                SetDatesActivity.class);
                         startActivity(intent);

                    } else if ((!check) && (!checkPrev)){
                        Toast.makeText(getApplicationContext(),
                                "Previous Round not Conducted yet!", Toast.LENGTH_LONG)
                                .show();
                    } else{
                        Toast.makeText(getApplicationContext(),
                                "Round already Conducted!", Toast.LENGTH_LONG)
                                .show();
                    }

                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please select a Round No.!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

    }

    private boolean checkRound(int roundNo) {
        //check whether the roundNo entered is conducted or not...
        //TODO check condition whether round is conducted or not
        if (roundNo > 3)
            return false;
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home__screen__admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(),
                    MainActivity.class);
            startActivity(intent);
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
