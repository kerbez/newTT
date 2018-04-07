package com.example.kerbe.newtt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kerbe on 04.04.2018.
 */

public class KlassDbHelper extends SQLiteOpenHelper {
    private  static final String DB_NAME = "KL";
    private static final int DB_VERSION = 2;
    public Context context;
    public KlassDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        Log.d("constructor", "hey");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE KLASS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "SUBJECT TEXT," +
                "TEACHER TEXT," +
                "PLACE TEXT," +
                "DAY TEXT," +
                "START TEXT," +
                "FINISH TEXT, " +
                "KIND TEXT," +
                "GROUPP TEXT)"
        );
        Log.d("hey", "onC");

    }
    public void insertKL(String sub, String tea, String place, String day, String start, String finish, String kind, String groupp){

        //KlassDbHelper k = new KlassDbHelper();
        Log.d("in insertKl", "this = " + this);
        SQLiteDatabase dbb = this.getWritableDatabase();
        ContentValues klValues = new ContentValues();
        klValues.put("SUBJECT", sub);
        klValues.put("TEACHER", tea);
        klValues.put("PLACE", place);
        klValues.put("DAY", day);
        klValues.put("START", start);
        klValues.put("FINISH", finish);
        klValues.put("KIND", kind);
        klValues.put("GROUPP", groupp);
        dbb.insert("KLASS", null, klValues);
    }

    public void delete(String id){
        SQLiteDatabase dbb = this.getWritableDatabase();
        dbb.delete("KL", "_id = ?", new String[] {id});
        dbb.close();
    }
    public Klass getKL(int id){
        SQLiteDatabase dbb = getReadableDatabase();
        Cursor cursor = dbb.query("KL", new String[] {"_id", "SUBJECT", "TEACHER","PLACE", "DAY", "START", "FINISH", "KIND", "GROUPP"}, "_id = ?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        Klass con = new Klass(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
        return con;
    }
    public ArrayList<Klass> getAllKlass(){
        Log.d("in getAllKlass", "this = " + this);
        ArrayList<Klass> l = new ArrayList<Klass>();
        String selQuery = "SELECT * FROM KL";
        SQLiteDatabase dbb = getReadableDatabase();
        Cursor cursor = dbb.rawQuery(selQuery, null);
        if(cursor.moveToFirst()){
                do{
                    Klass k = new Klass(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8) );
                    l.add(k);
                }while (cursor.moveToNext());
        }
        return l;
    }
    public int getCount(){
        SQLiteDatabase dbb = this.getReadableDatabase();
        Cursor cursor = dbb.rawQuery("SELECT * FROM K", null);
        int c = cursor.getCount();
        cursor.close();
        return c;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
