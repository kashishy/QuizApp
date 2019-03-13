package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView t;
    Button b1,b2;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle b=getIntent().getExtras();
        t=(TextView)findViewById(R.id.textView3);
        x=b.getInt("x1");
        String s=Integer.toString(x);
        t.setText(s);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(ResultActivity.this,LoginActivity.class);
                startActivity(it);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        Toast.makeText(this,"Can not Go Back",Toast.LENGTH_SHORT).show();
    }
}
