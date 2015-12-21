package com.vishwajeets3.loginregistration.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.vishwajeets3.loginregistration.R;

public class LoginChoiceActivity extends Activity {

        private static final String TAG = RegisterActivity.class.getSimpleName();
        private Button btnAdmin;
        private Button btnStud;
        private ImageView Student;
        private ImageView Admin;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_choice);

            Student = (ImageView) findViewById(R.id.imageView);
            Admin = (ImageView) findViewById(R.id.imageView1);
            btnAdmin = (Button) findViewById(R.id.btnAdmin);
            btnStud = (Button) findViewById(R.id.btnStud);

            btnStud.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),
                            LoginActivity.class);
                    i.putExtra("loginAs","1");
                    startActivity(i);
                    finish();
                }
            });

            btnAdmin.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),
                            LoginActivity.class);
                    i.putExtra("loginAs","2");
                    startActivity(i);
                    finish();
                }
            });

            Admin.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),
                            LoginActivity.class);
                    i.putExtra("loginAs", "2");
                    startActivity(i);
                    finish();
                }
            });

            Student.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),
                            LoginActivity.class);
                    i.putExtra("loginAs","1");
                    startActivity(i);
                    finish();
                }
            });

        }


}
