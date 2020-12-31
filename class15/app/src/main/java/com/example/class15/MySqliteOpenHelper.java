package com.example.class15;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MySqliteOpenHelper extends SQLiteOpenHelper {
   public static final  String sql="create table book( id integer primary key autoincrement,bookname text,author text,price real,page integer)";
    private Context context;
    public MySqliteOpenHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        this.context=context;
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        Toast.makeText(context,"book table create success",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
