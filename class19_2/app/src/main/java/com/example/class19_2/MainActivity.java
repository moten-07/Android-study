package com.example.class19_2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText uname,upass;
    Button logBut,seachBut;
    ListView listView;
    List<String> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inti();
        logBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=uname.getText().toString();
                String pass=upass.getText().toString();
                String uristr="content://com.example.class19.MyProvider/userinfo/1";
                Uri uri= Uri.parse(uristr);
                Cursor cursor=getContentResolver().query(uri,new String[]{"userpass"},"username=?",new String[]{name},null);
                if(cursor.moveToFirst()){
                    Log.d("V","yes s");
                    String pass1=cursor.getString(cursor.getColumnIndex("userpass"));
                    if(pass.equals(pass1)){
                        Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        seachBut.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String uristr="content://com.example.class19.MyProvider/userinfo/0";
                Uri uri= Uri.parse(uristr);
                list.clear();
                Cursor cursor=getContentResolver().query(uri,null,null,null,null);
                if(cursor.moveToNext()){
                    Log.d("s","is yes");
                }else{
                    Log.d("s","is no");
                }
                while(cursor.moveToNext()){
                    String name=cursor.getString(1);
                    String pass=cursor.getString(2);
                    String s=name+"   "+pass;
                    list.add(s);
                }
                adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,list);
                listView.setAdapter(adapter);
            }
        });
    }
    public void inti(){
        uname=findViewById(R.id.editText);
        upass=findViewById(R.id.editText2);
        logBut=findViewById(R.id.log);
        seachBut=findViewById(R.id.search);
        listView=findViewById(R.id.userset);
        list=new ArrayList<>();
    }
}
