package com.example.quickoff;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//a class that create database and override various functions
public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    public static final String TABLE_NAME = "results";
    public static final String COLUMN_PHONE_NAME = "Phone_Name";
    public static final String COLUMN_PRICE = "Price";
    public static final String COLUMN_COMPANY = "Company_Name";
    public static final String COLUMN_SOURCE = "Source";
    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    // initialize the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE results (Phone_Name TEXT, Price TEXT, Company_Name TEXT, Source TEXT);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public String loadHandler() {
        String result = "";
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    // this method tries to find a given product name in the product name column of the database
    // and create a product instance to store all the information
    public Product findAmazonHandler(String productname) {
        // find products that are from Amazon in the database
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_SOURCE + " LIKE " + "'%Amazon%'" + "AND " + COLUMN_PHONE_NAME +" LIKE " + "'%" + productname + "%'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Product product = new Product();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            product.setName(cursor.getString(0));
            product.setPrice(cursor.getString(1));
            product.setDescription(cursor.getString(2));
            String source = cursor.getString(3);
            if(source.equals("Amazon"))
                product.setSource(true);
            else{product.setSource(false);}
            cursor.close();
        } else {
            product = null;
        }
        db.close();
        return product;
    }

    // this method tries to find a given product name in the product name column of the database
    // and create a product instance to store all the information
    public Product findTmallHandler(String productname) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_SOURCE + " LIKE " + "'%tmall%'" + "AND " + COLUMN_PHONE_NAME +" LIKE " + "'%" + productname + "%'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Product product = new Product();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            product.setName(cursor.getString(0));
            product.setPrice(cursor.getString(1));
            product.setDescription(cursor.getString(2));
            String source = cursor.getString(3);
            if(source.equals("tmall"))
                product.setSource(true);
            else{product.setSource(false);}
            cursor.close();
        } else {
            product = null;
        }
        db.close();
        return product;
    }

    // this method takes a instance of product as input and add it to the database
    public void addHandler(Product product) {
        // create a ContentValues instance and store all the information about input product in it
        ContentValues values = new ContentValues(4);
        values.put(COLUMN_PHONE_NAME, product.getName());
        values.put(COLUMN_PRICE, product.getPrice());
        values.put(COLUMN_COMPANY, product.getDescription());
        if(product.getSource()) {
            values.put(COLUMN_SOURCE, "Amazon");
        }
        else {
            values.put(COLUMN_SOURCE, "Tmall");
        }
        // put the ContentValues in the database
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    
}