package com.example.acer.class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //相当于main方法
        super.onCreate(savedInstanceState);                 //继承父类方法
        setContentView(R.layout.activity_main);            //设置内容的布局
    }
}
