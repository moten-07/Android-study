package com.example.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    String [] booknameset={};
    List<Book> bookset=new ArrayList<Book>();
    int[] bookimgset={R.mipmap.book1,R.mipmap.book2,R.mipmap.book3,R.mipmap.book4,R.mipmap.book5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.listView1);
        //绑定数据
        //booknameset=getResources().getStringArray(R.array.booknames);//****
        //声明适配器对象
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1,booknameset);
        intial();
        BookAdapter adapter=new BookAdapter(Main2Activity.this,bookset);
        //绑定适配器
        listView.setAdapter(adapter);

    }

    public void intial(){
        booknameset=getResources().getStringArray(R.array.booknames);//*****
        //完成Book对象的初始化
        for (int i=0;i<booknameset.length;i++){
            Book bookitem=new Book(bookimgset[i%5],booknameset[i]);//图片和书名合成Book对象
            bookset.add(bookitem);//将Book对象添加到list中
        }

    }
}
