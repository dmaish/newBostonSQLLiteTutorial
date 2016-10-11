package com.example.danielmaina.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by danielmaina on 10/5/16.
 */
public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    //the .db extension below functions to tell android that the file name is a db file
    private static final String DATABASE_NAME = "products.db";
    //name of the table to use in the database
    private static final String TABLE_PRODUCTS="products";

    //columns in the database table
    private static final String COLUMN_ID="id";
    private static final String COLUMN_PRODUCTNAME="productname";

    public MyDBHandler(Context context,String name , SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME , factory, DATABASE_VERSION);
    }

    @Override
    //instantiates the database -the table and its constituent columns
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query ="CREATE TABLE" +TABLE_PRODUCTS+ "("+COLUMN_ID +
                "INTEGER PRIMARY KEY AUTOINCREMENT" +
                COLUMN_PRODUCTNAME + "TEXT" +
                ");";
        //executing the query created above
    sqLiteDatabase.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //if database has changed,the current table will be deleted using the following command
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);
        //the the oncreate method below will be run to create the new table(upgrading
        onCreate(sqLiteDatabase);

    }

}
