package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Userdetails.db";
    public static final String TABLE_NAME = "userdetails";
    public static final String COLUMN_1="id";
    public static final String COLUMN_2="urname";
    public static final String COLUMN_3="urpass";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(id integer  primary key autoincrement,urname text,urpass text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertdata(String uname,String upass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_2, uname);
        contentValues.put(COLUMN_3, upass);
        long result=db.insert(TABLE_NAME,null,contentValues);
        db.close();
        if(result==-1)
            return false;
        else
            return true;
    }
    public  Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }
}
