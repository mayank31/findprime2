package com.example.mayank.findprime;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hint_here extends AppCompatActivity {

    private TextView hinttext;
    private Button hintcheat;
    static int hint_taken=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_here);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        hinttext=(TextView)findViewById(R.id.hinttext);
        hintcheat=(Button)findViewById(R.id.cheathint);
       // hint_taken=0;
        hinttext.setText("");
        if(getIntent().getBooleanExtra("hint_taken",false)==false)
            hint_taken=0;
        else
            hint_taken=1;
        hintcheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hint_taken=1;
                hinttext.setText("Prime Number is a Number which is only divisible and 1 and with the Number itself");
            }
        });


    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (getResources().getInteger(hint_taken)==1) {
           // setContentView(R.layout.landscapeView);
            hint_taken=1;

        } else {
            //setContentView(R.layout.portraitView);
            hint_taken=0;
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("hint_taken",hint_taken);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

}
