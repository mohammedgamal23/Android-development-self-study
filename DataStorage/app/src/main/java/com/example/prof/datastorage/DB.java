package com.example.prof.datastorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

// Data model out of the activity to make database
public class DB {
    SQLiteDatabase sql;
    public DB(SQLiteDatabase sql)
    {
        this.sql = sql;
    }
    public void createTable()
    {
        try{
            sql.execSQL("Create table if not exists student" +
                    "(stu_id integer primary key autoincrement, stu_name text)");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void insertStudent(String str)
    {
        try{
            sql.execSQL("insert into student (stu_name) values ('"+str+"') ");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    public ArrayList<String> getAll()
    {
        ArrayList<String> arr = new ArrayList<String>();
        Cursor cursor = sql.rawQuery("select stu_name from student",null);
        if(cursor.getCount()>0)
        {
            while(cursor.moveToNext())
            {
                arr.add(cursor.getString(0));
            }
        }
        cursor.close();
        return arr;
    }
}