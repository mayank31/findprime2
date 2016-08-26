    package com.example.mayank.findprime;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button yes;
    private Button no;
    private Button next,cheat,hint;
    private TextView ques;
    Boolean cheated,hinttaken;

    int randno;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    ques = (TextView) findViewById(R.id.ques);
    yes = (Button) findViewById(R.id.yes);
    no = (Button) findViewById(R.id.no);
    next = (Button) findViewById(R.id.next);
    cheat=(Button)findViewById(R.id.cheat);
        hint=(Button)findViewById(R.id.hint);
    final Random r = new Random();
        randno = r.nextInt(1000-0) % 1001;
        cheated=false;
        hinttaken=false;
    ques.setText("Is " + randno + " a prime number?");
    yes.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (checkprime(randno) == true) {
                if(cheated==true&&hinttaken==false)
                {
                    Toast.makeText(getApplicationContext(), "You have cheated", Toast.LENGTH_SHORT).show();
                }
                else if(cheated==false&&hinttaken==true)
                {
                    Toast.makeText(getApplicationContext(), "You have taken a hint", Toast.LENGTH_SHORT).show();
                }
                else if(cheated==true&&hinttaken==true)
                {
                    Toast.makeText(getApplicationContext(), "You have cheated and taken a hint also", Toast.LENGTH_SHORT).show();
                }
                else
                Toast.makeText(getApplicationContext(), "Correct ans", Toast.LENGTH_SHORT).show();
            } else {
                if(cheated==true&&hinttaken==false)
                {
                    Toast.makeText(getApplicationContext(), "You have cheated", Toast.LENGTH_SHORT).show();
                }
                else if(cheated==false&&hinttaken==true)
                {
                    Toast.makeText(getApplicationContext(), "You have taken a hint", Toast.LENGTH_SHORT).show();
                }
                else if(cheated==true&&hinttaken==true)
                {
                    Toast.makeText(getApplicationContext(), "You have cheated and taken a hint also", Toast.LENGTH_SHORT).show();
                }
                else
                Toast.makeText(getApplicationContext(), "InCorrect ans", Toast.LENGTH_LONG).show();
            }
        }
    });
    no.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (checkprime(randno) == true) {
                if(cheated==true&&hinttaken==false)
                {
                    Toast.makeText(getApplicationContext(), "You have cheated", Toast.LENGTH_SHORT).show();
                }
                else if(cheated==false&&hinttaken==true)
                {
                    Toast.makeText(getApplicationContext(), "You have taken a hint", Toast.LENGTH_SHORT).show();
                }
                else if(cheated==true&&hinttaken==true)
                {
                    Toast.makeText(getApplicationContext(), "You have cheated and taken a hint also", Toast.LENGTH_SHORT).show();
                }
                else
                Toast.makeText(getApplicationContext(), "InCorrect ans", Toast.LENGTH_SHORT).show();
            } else {
                if(cheated==true&&hinttaken==false)
                {
                    Toast.makeText(getApplicationContext(), "You have cheated", Toast.LENGTH_SHORT).show();
                }
                else if(cheated==false&&hinttaken==true)
                {
                    Toast.makeText(getApplicationContext(), "You have taken a hint", Toast.LENGTH_SHORT).show();
                }
                else if(cheated==true&&hinttaken==true)
                {
                    Toast.makeText(getApplicationContext(), "You have cheated and taken a hint also", Toast.LENGTH_SHORT).show();
                }
                else
                Toast.makeText(getApplicationContext(), "Correct ans", Toast.LENGTH_SHORT).show();
            }
        }
    });
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // Random r1 = new Random();
            cheated=false;
            hinttaken=false;
            randno = r.nextInt(1000-0) % 1001;
            ques.setText("Is " + randno + " a prime number?");
        }
    });
    hint.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), Hint_here.class);
            i.putExtra("Hint_ans",hinttaken);
            startActivityForResult(i,1);
        }
    });
        cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flag=checkprime(randno);
                Intent i = new Intent(getApplicationContext(), Cheat_here.class);
                i.putExtra("number",randno);
                i.putExtra("ans",flag);
                i.putExtra("cheat_taken",cheated);
                startActivityForResult(i,1);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(cheated!=Boolean.TRUE) {
            int clicked = data.getIntExtra("clicked", 0);
            if (clicked == 1) {
                cheated = true;

            } else
                cheated = false;
        }
        if(hinttaken!=Boolean.TRUE) {
            int hint_clicked = data.getIntExtra("hint_taken", 0);
            if (hint_clicked == 1) {
                hinttaken = true;

            } else
                hinttaken = false;
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
    public boolean checkprime(int no)
    {
        boolean ans;
        ans=true;
        int i=0;
        for(i=2;i<=no/2;i++)
        {
            if((no%i)==0)
            {
                ans=false;
                 break;
            }
        }
        return ans;
    }

}
