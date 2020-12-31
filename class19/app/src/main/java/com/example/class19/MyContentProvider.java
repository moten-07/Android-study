package com.example.class19;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public static  final  String AUTHORTY="com.example.class19.MyProvider";
    public static final String PATH="userinfo" ;
    public static UriMatcher uriMatcher;
    MyHelpter helpter;
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORTY,PATH,0);
        uriMatcher.addURI(AUTHORTY,PATH+"/#",1);
    }
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        SQLiteDatabase db=helpter.getWritableDatabase();
        long id=db.insert(PATH,null,values);
        Uri uri1=Uri.parse("content://"+AUTHORTY+"/"+PATH+"/"+id);
        db.close();
        return uri1;

    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        helpter=new MyHelpter(getContext(),"userstor.db",null,2);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        Cursor cursor=null;
        SQLiteDatabase db=helpter.getReadableDatabase();
        switch (uriMatcher.match(uri)){
            case 0:
                cursor=db.query(PATH,null,null,null,null,null,null);
                break;
            case 1:
                cursor=db.query(PATH,null,selection,selectionArgs,null,null,sortOrder);
                break;
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
