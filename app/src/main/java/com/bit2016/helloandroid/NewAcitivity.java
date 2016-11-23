package com.bit2016.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class NewAcitivity extends AppCompatActivity {

    private static String L_TAG = "NewAcitivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_acitivity);

        int dataNumber = getIntent().getIntExtra("data-number",0);
        String dataString = getIntent().getStringExtra("data-string");

        TextView calleetv = (TextView) findViewById(R.id.calleetv);
        String result = "data-number :" + dataNumber + "||  data-String :" + dataString ;
        calleetv.setText(result);

        findViewById(R.id.callee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data-Number",10);
                intent.putExtra("data-String","hello android");

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(L_TAG,"onBackPressed");
    }
}
