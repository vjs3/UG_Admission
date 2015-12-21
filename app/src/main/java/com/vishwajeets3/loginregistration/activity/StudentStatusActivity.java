package com.vishwajeets3.loginregistration.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vishwajeets3.loginregistration.R;

public class StudentStatusActivity extends AppCompatActivity {

    String appId;
    TextView tvAppId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_status);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent intent = getIntent();
        appId = intent.getStringExtra("appId");

        tvAppId = (TextView) findViewById(R.id.textViewApplicationId);
        tvAppId.setText(appId);

    }
}
