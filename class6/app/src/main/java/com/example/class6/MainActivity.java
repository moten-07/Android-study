package com.example.class6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button but1,but2;
    public EditText username;
    //抽象的初始化方法，完成对控件的初始化操作
    public void initial(){
        but1=findViewById(R.id.but1);
        but2=findViewById(R.id.but2);
        username=findViewById(R.id.username);
    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.but1:
                //Intent intent =new Intent();
                //intent.setAction(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));

                //传递数据，跳转b不同的activity
                String name=username.getText().toString();
                if(name!=null && !name.equals("")){
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("userName",name);
                    startActivity(intent);
                }else{
                    //context:当前活动本身
                    //text：提示错误信息
                    //int:提示框显示长度
                    Toast.makeText(MainActivity.this,"输入为空！",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.but2:
                //Intent intent2 =new Intent();
                //intent2.setAction(Intent.ACTION_DIAL);
                //intent2.setData(Uri.parse("tel:1008611"));
//                startActivity(intent2);
                username.setText(null);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        //设置监听
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        username.setOnClickListener(this);

    }

}
