package com.example.sqlfirstlook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
    super(context, "theDatabase", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table formTable(site text primary key, user text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists formTable");
    onCreate(db);
    }
}
