package com.example.mayank.findprime;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cheat_here extends AppCompatActivity {

    TextView text_cheat,text_ans;
    Button cheat_button;
    Boolean flag;
    int ans;
    static int clicked=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat_here);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      //  clicked=0;
       text_cheat=(TextView) findViewById(R.id.cheattext);
        text_ans=(TextView)findViewById(R.id.cheatans);
        cheat_button=(Button) findViewById(R.id.cheatbutton);
        text_ans.setText("");
        ans=getIntent().getIntExtra("number",0);
        flag=getIntent().getBooleanExtra("ans",true);
        text_cheat.setText("Click on Show Ans to view whether "+ans+" is prime number or not");
        cheat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked=1;
                if(flag==true)
                {
                    text_ans.setText(ans+" is a prime no");
                }
                else
                {
                    text_ans.setText(ans+" is not a prime no");
                }

            }
        });
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (getResources().getInteger(clicked)==1) {
            // setContentView(R.layout.landscapeView);
            clicked=1;

        } else {
            //setContentView(R.layout.portraitView);
            clicked=0;
        }
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("clicked",clicked);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

    }

}
