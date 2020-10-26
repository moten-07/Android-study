package com.example.class11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.Recy1);

    }

    //加载数据初始化
    public void intiData(){
        list=new ArrayList<String>();
        for (int i=1;i<=30;i++){
            String item="item"+i;
            list.add(item);
        }
    }
}
