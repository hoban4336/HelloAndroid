package com.bit2016.helloandroid;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CALLERACTIVITY =101 ;
    private static String L_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(L_TAG, "onCreate called:" + savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.caller).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewAcitivity.class);
                intent.putExtra("data-number",10);
                intent.putExtra("data-string","hello android");
                startActivityForResult(intent, REQUEST_CODE_CALLERACTIVITY);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_CALLERACTIVITY) {
            if (resultCode == RESULT_OK) {
                int dataNumber = data.getIntExtra("data-Number", 0);
                String dataString = data.getStringExtra("data-String");

                String result = "data number " + dataNumber + " data-String " + dataString;
                TextView tv = (TextView) findViewById(R.id.tvcaller);
                tv.setText(result);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(L_TAG,"onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(L_TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(L_TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(L_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(L_TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(L_TAG,"onRestart");
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.d(L_TAG,"onPostCreate: " + savedInstanceState );
    }
}
