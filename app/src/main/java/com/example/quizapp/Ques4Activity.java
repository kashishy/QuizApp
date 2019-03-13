package com.example.quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ques4Activity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    //Global g=(Global)getApplication();
    //int t=g.getData();
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques4);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        b3=(Button)findViewById(R.id.button4);
        b4=(Button)findViewById(R.id.button5);
        Resources resources = getResources();
        Bundle b=getIntent().getExtras();
        x=b.getInt("x1");
        // t=g.getData();
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // t++;
                //g.setData(t);
                x++;
                Intent it = new Intent(Ques4Activity.this, Ques5Activity.class);
                it.putExtra("x1", x);
                startActivity(it);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Ques4Activity.this,Ques5Activity.class);
                it.putExtra("x1", x);
                startActivity(it);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Ques4Activity.this,Ques5Activity.class);
                it.putExtra("x1", x);
                startActivity(it);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Ques4Activity.this,Ques5Activity.class);
                it.putExtra("x1", x);
                startActivity(it);
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        Toast.makeText(this,"Can not Go Back",Toast.LENGTH_SHORT).show();
        // Your Code Here. Leave empty if you want nothing to happen on back press.
    }
}
