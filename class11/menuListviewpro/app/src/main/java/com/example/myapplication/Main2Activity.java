package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    String[] booknaneset={};//存储图书名字的数组

    List<book> bookset=new ArrayList<book>();//存储图书信息的集合对象
    //存储图书图片的数组
    int[] bookimgset={R.mipmap.book1,R.mipmap.book2,R.mipmap.book3,R.mipmap.book4,R.mipmap.book5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.listView1);
       intial();
       bookAdapter adapter=new bookAdapter(Main2Activity.this,bookset);
        //声明适配器对象
       // ArrayAdapter<String> adapter=new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1,booknaneset);
       //绑定适配器
        listView.setAdapter(adapter);
        //listview中数据项单击监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                book bookitem=bookset.get(position);
                Toast.makeText(Main2Activity.this,bookitem.getBookimg()+bookitem.getBookname(),Toast.LENGTH_SHORT).show();
            }
        });//每一项的单击事件
    }

    public void intial(){
        booknaneset=getResources().getStringArray(R.array.booknames);
        //完成book对象的初始化
        for (int i=0;i<booknaneset.length;i++){
            book bookitem=new book(bookimgset[i%5],booknaneset[i]);//将图片和书名合成一个book对象
            bookset.add(bookitem);//将book对象添加到List中
        }

    }

}
