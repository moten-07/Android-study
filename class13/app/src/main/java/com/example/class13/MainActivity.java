package com.example.class13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText phone;
    public Button button,rebut,sendbut,unrebut;
    MyReceiver2 receiver2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        button.setOnClickListener(this);

        rebut=findViewById(R.id.button1);
        sendbut=findViewById(R.id.button2);
        unrebut=findViewById(R.id.button3);
        rebut.setOnClickListener(this);
        sendbut.setOnClickListener(this);
        unrebut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                /*
                String phonestr=phone.getText().toString();
                SharedPreferences sp=getSharedPreferences("config",MODE_PRIVATE);   //私有的
                sp.edit().putString("phone",phonestr).commit();
                */
                 //发送有序广播
                Intent intent1=new Intent("sss.edu.cn");
                sendOrderedBroadcast(intent1,null);
                break;
            case R.id.button1:
                //注册广播接受者
                IntentFilter filter=new IntentFilter();//创建过滤器
                filter.addAction("myself broadcast");//设置要过滤的action
                receiver2=new MyReceiver2();//创建接受者
                registerReceiver(receiver2,filter);
                break;
            case R.id.button2:
                //发送自定义广播
                Intent intent2=new Intent("myself broadcast");
                sendBroadcast(intent2);//发送一个自定义广播
                break;
            case R.id.button3:
                unregisterReceiver(receiver2);
                receiver2=null;
                break;

        }


    }
}
