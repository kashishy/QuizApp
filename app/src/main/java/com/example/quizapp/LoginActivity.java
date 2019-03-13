package com.example.quizapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginb,signb;
    DatabaseHelper mydb;
    int x=0,f;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        loginb=findViewById(R.id.llogin);
        signb=findViewById(R.id.lsignup);
        e1=findViewById(R.id.lusername);
        e2=findViewById(R.id.lpassword);
        mydb=new DatabaseHelper(this);
        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f = 0;
                Cursor cursor = mydb.getAllData();
                if (cursor.getCount() == 0) {
                    showAll("Error", "No data found");
                } else {
                    StringBuffer buffer=new StringBuffer();
                    while (cursor.moveToNext()) {
                        if (cursor.getString(1).equals(e1.getText().toString())) {
                            if (cursor.getString(2).equals(e2.getText().toString())) {
                                f = 1;
                                break;
                            }
                        }
                    }
                    if (f == 0) {
                        Toast.makeText(LoginActivity.this, "Username or Password not found,signup first", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent it2 = new Intent(LoginActivity.this, Ques1Activity.class);
                        it2.putExtra("x1", x);
                        startActivity(it2);
                    }
                }
            }
        });
        signb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(it1);
            }
        });
    }
    public  void showAll(String title,String message){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
