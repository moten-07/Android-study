package com.example.class11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<book> list;
    int [] bookimg={R.mipmap.book1,R.mipmap.book2,R.mipmap.book3,R.mipmap.book4,R.mipmap.book5};
    String[] booknaneset={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.Recy1);
        intiData();

        //创建布局管理器对象
        //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//改成水平显示
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //换个布局，一行仨
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,5);
        //recyclerView.setLayoutManager(gridLayoutManager);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        //recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter adapter=new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        //添加默认分割线
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        //添加自定义分割线
        /*
        DividerItemDecoration itemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.ddd));
        recyclerView.addItemDecoration(itemDecoration);
         */
    }

    //加载数据初始化
    public void intiData(){

        booknaneset=getResources().getStringArray(R.array.booknames);
        list=new ArrayList<book>();
        for (int i=1;i<=30;i++){
            String bookname="book"+i;
            book book=new book(bookimg[(i-1)%5],booknaneset[(i-1)%booknaneset.length]);
            list.add(book);
        }
    }
}
