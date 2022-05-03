package com.example.findme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DBName="MyDatabase";
    public static final int DBVersion=1;
    public MyDatabase(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String userTable="Create TABLE User(name TEXT,email TEXT,password TEXT)";
        db.execSQL(userTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}