package com.example.orbitalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Event.db";
    public static final String TABLE_NAME = "event_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "DATE";
    public static final String COL4 = "AMOUNT";
    public static final String COL5 = "PAX";

    private static final String DATABASE_ALTER_TEAM_1 = "ALTER TABLE "
            + TABLE_NAME + " ADD COLUMN " + COL5 + " string;";


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " PAX INTEGER, NAME TEXT, DATE TEXT, AMOUNT DOUBLE)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion){
            db.execSQL(DATABASE_ALTER_TEAM_1);
        }
//        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
//        onCreate(db);
    }

    public boolean addData(String name, String date, String amount, String pax) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, date);
        contentValues.put(COL4, amount);
        contentValues.put(COL5, pax);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        //cursor is an interface which provides random read write access to the result set returned
        //storing the data into the Cursor instance
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
    public boolean updateData(String id, String name, String date, String cost, String pax){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, id);
        contentValues.put(COL2, name);
        contentValues.put(COL3, date);
        contentValues.put(COL4, cost);
        contentValues.put(COL5, pax);
        db.update(TABLE_NAME, contentValues,"ID = ?",new String[] { id });
        return true;
    }
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}
