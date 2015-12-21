package com.vishwajeets3.loginregistration.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import com.vishwajeets3.loginregistration.R;

public class RoundStatusActivity extends AppCompatActivity {

    private TableLayout table_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_status);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        table_layout = (TableLayout) findViewById(R.id.tableview);
        table_layout.setPadding(15, 3, 15, 3);


        for (int i = 0; i < 50; i++)
        {

            TableRow row = new TableRow(this);
            row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));

            row.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TableRow tr1=(TableRow)view;
                    TextView tv1= (TextView)tr1.getChildAt(0);

                    Intent i = new Intent(getApplicationContext(),
                            StudentStatusActivity.class);
                    i.putExtra("appId",tv1.getText().toString());
                    startActivity(i);

                }
            });

            // inner for loop
            for (int j = 1; j <= 3; j++) {

                TextView tv = new TextView(this);
                tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                //tv.setBackgroundResource(R.drawable.border_cell);
                tv.setPadding(5, 5, 5, 5);
                //TODO insert data from database
                tv.setText("R " + i + ", C" + j);

                row.addView(tv);

            }

            table_layout.addView(row);

        }

    }
}
