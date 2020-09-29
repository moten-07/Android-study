package com.example.class6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView uname=(TextView)findViewById(R.id.uname);
        //从intent中取数据
        Intent intent=getIntent();
        String name=intent.getStringExtra("userName");
        uname.setText(name);
    }
}
