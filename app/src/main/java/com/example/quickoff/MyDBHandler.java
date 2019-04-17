package com.example.quickoff;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    public static final String TABLE_NAME = "results";
    public static final String COLUMN_PHONE_NAME = "Phone Name";
    public static final String COLUMN_PRICE = "Price";
    public static final String COLUMN_COMPANY = "Company Name";
    public static final String COLUMN_SOURCE = "Source";
    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_PHONE_NAME +
                "TEXT," + COLUMN_PRICE + "TEXT" + COLUMN_COMPANY + "TEXT" + COLUMN_SOURCE + "Text)";
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
    public Product findHandler(String productname) {
        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_PHONE_NAME + " LIKE " + "'%" + productname + "%'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Product product = new Product();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            product.setPrice(Integer.parseInt(cursor.getString(0)));
            product.setName(cursor.getString(1));
            cursor.close();
        } else {
            product = null;
        }
        db.close();
        return product;
    }
    
}