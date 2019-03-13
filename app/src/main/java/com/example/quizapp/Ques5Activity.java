package com.example.quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ques5Activity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    // Global g=(Global)getApplication();
    //int t=g.getData();
    Toolbar toolbar;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques5);
        toolbar=findViewById(R.id.toolbar_id_5);
        setSupportActionBar(toolbar);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        b3=(Button)findViewById(R.id.button4);
        b4=(Button)findViewById(R.id.button5);
        Resources resources = getResources();
        //  t=g.getData();
        Bundle b=getIntent().getExtras();
        x=b.getInt("x1");
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //t++;
                //g.setData(t);
                x++;
                Intent it = new Intent(Ques5Activity.this, ResultActivity.class);
                it.putExtra("x1", x);
                startActivity(it);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Ques5Activity.this,ResultActivity.class);
                it.putExtra("x1", x);
                startActivity(it);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Ques5Activity.this,ResultActivity.class);
                it.putExtra("x1", x);
                startActivity(it);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Ques5Activity.this,ResultActivity.class);
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
