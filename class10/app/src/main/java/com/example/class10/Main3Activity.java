package com.example.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    ListView listView;
    String [] appNameSet;
    List <Book> appSet=new ArrayList<Book>();
    int [] appLogo={R.mipmap.dz,R.mipmap.jd,R.mipmap.qq,R.mipmap.tm,R.mipmap.uc,R.mipmap.wx,R.mipmap.xl};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView=findViewById(R.id.listView2);
        inital();
        BookAdapter adapter=new BookAdapter(Main3Activity.this,appSet);
        //绑定适配器
        listView.setAdapter(adapter);
    }

    public void inital(){
        appNameSet=getResources().getStringArray(R.array.appName);
        for (int i=0;i<appNameSet.length;i++){
            Book app=new Book(appLogo[i],appNameSet[i]);
            appSet.add(app);
        }
    }
}
