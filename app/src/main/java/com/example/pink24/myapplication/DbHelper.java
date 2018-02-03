package com.example.pink24.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pink24 on 2/3/18.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String DbName="MyDB";
    private String Table_name="Java";
    private String col1_id="id";
    private String col2_name="name";
    private String col3_age="age";

    public DbHelper(Context context) {
        super(context, DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Java(Id Integer Primary Key Autoincrement,"+
                "Name VarChar(15) Not null, Age Text Not null )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists Java");
    }


    public boolean myInsert(String name, String age){
     SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(col2_name, name);
        contentValues.put(col3_age, age);
        long i=sqLiteDatabase.insert(Table_name, null,contentValues);
        if(i==-1){return false;}
        else {return true;}
    }


    public Cursor getData(){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from Java", null);
        return cursor;
    }


}