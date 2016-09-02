package com.example.danielmaina.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        String query ="CREATE TABLE "  + TABLE_PRODUCTS + " ( " + COLUMN_ID  +
                " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_PRODUCTNAME + " TEXT" +
                ");";
        //executing the query created above
    sqLiteDatabase.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase
                                      sqLiteDatabase, int i, int i1) {

        //if database has changed,the current table will be deleted using the following command
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        //the the oncreate method below will be run to create the new table(upgrading
        onCreate(sqLiteDatabase);

    }


    //adding a new row(product) to the database
    //the following method takes the Products class as a parametre
    public void addProduct(Products product){
        //contentValues is an inbuilt class that allows you to add rows to your database
        //allows you to set values for different columns and insert them in one statement
        ContentValues values =new ContentValues();
        values.put(COLUMN_PRODUCTNAME,product.get_productname());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_PRODUCTS,null,values);
        sqLiteDatabase.close();
    }

    //method to delete a row(product)from the database
    //for a product to be deleted, you have to type its name in the edittext and then press delete
    //the product name in the database corresponding to the product name in the edittext is then deleted
    public void deleteProduct(String productName){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");
            }




    //method to convert the databses into a string so that the contents in the said database can
    //in a certain view-maybe  listView or whatever
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query ="SELECT * FROM "+TABLE_PRODUCTS+" WHERE 1";
        //for the above statement *=every column , 1=every row

        //Cursor points to a location in your results
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        //move the cursor to the very first row of your results
        c.moveToFirst();

        //the following code loops through the items in the database and adds them as a string
        //to be printed in whatever view
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("productname"))!=null){
                dbString += c.getString(c.getColumnIndex("productname"));
                dbString += "\n";
            }
        }

        sqLiteDatabase.close();
        return dbString;


    }

}


































