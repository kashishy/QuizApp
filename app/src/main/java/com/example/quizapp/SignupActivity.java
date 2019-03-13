package com.example.quizapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    Button sb,lb;
    EditText ue,pe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sb=(Button)findViewById(R.id.button7);
        lb=(Button)findViewById(R.id.button8);
        ue=(EditText)findViewById(R.id.editText);
        pe=(EditText)findViewById(R.id.editText3);
        mydb=new DatabaseHelper(this);
        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(it);
            }
        });
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ue.getText().equals("") || pe.getText().equals(""))
                {
                    Toast.makeText(SignupActivity.this,"Enter details correctly!!!",Toast.LENGTH_LONG).show();
                }
                else{
                    int f = 0;
                    Cursor cursor = mydb.getAllData();
                    while (cursor.moveToNext()) {
                        if (cursor.getString(1).equals(ue.getText().toString())) {
                            f = 1;
                        }
                    }
                    if (f == 0) {
                        boolean check = mydb.insertdata(ue.getText().toString(), pe.getText().toString());
                        Toast.makeText(SignupActivity.this,"Data inserted,Login to start",Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(it);
                    }
                    else{
                        Toast.makeText(SignupActivity.this,"Username already exits",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
