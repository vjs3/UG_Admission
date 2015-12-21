package com.vishwajeets3.loginregistration.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.vishwajeets3.loginregistration.R;

import java.util.ArrayList;
import java.util.List;

public class SetDatesActivity extends AppCompatActivity {

    private Button btnSet;
    private Spinner spinnerDate;
    private Spinner spinnerMonth;
    private Spinner spinnerYear;

    private String str[] = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

    List<String> list, list1, list2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_dates);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);


        btnSet = (Button) findViewById(R.id.btnSet);
        spinnerDate = (Spinner) findViewById(R.id.spinner);
        spinnerMonth = (Spinner) findViewById(R.id.spinner1);
        spinnerYear = (Spinner) findViewById(R.id.spinner2);


        list = new ArrayList<String>();
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list.add("");
        list1.add("");
        list2.add("");

        for(int i=0 ; i<=30 ; i++) {
            list.add(str[i]);
        }
        ArrayAdapter<String> adp = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list);
        //adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDate.setAdapter(adp);

        for(int i=0 ; i<=11 ; i++) {
            list1.add(str[i]);
        }
        ArrayAdapter<String> adp1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list1);
        //adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adp1);

        for(int i=15 ; i<=60 ; i++) {
            list2.add("20"+i);
        }
        ArrayAdapter<String> adp2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list2);
        //adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adp2);
        spinnerYear.setSelection(1);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = spinnerDate.getSelectedItem().toString().trim();
                String month = spinnerMonth.getSelectedItem().toString().trim();

                // Check for empty data in the form
                if (!date.equalsIgnoreCase("") && !month.equalsIgnoreCase("")) {
                    int d = Integer.parseInt(date);
                    int m = Integer.parseInt(month);
                    boolean check = validateDate(d, m);
                    if(!check)
                    {
                        Toast.makeText(getApplicationContext(),
                                "\t\t\t\t\t\tInvalid Date entered!\nEnter a date seven days after from current date", Toast.LENGTH_LONG)
                                .show();
                    } else{
                        Toast.makeText(getApplicationContext(),
                                "Date Successfully entered!", Toast.LENGTH_LONG)
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

    private boolean validateDate(int date, int month) {
        //TODO replace if condition with check condition for date validation with current date+7
        if(date < 10)
            return false;
        return true;
    }
}
