package com.example.class23_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView number,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        number=findViewById(R.id.getNumber);
        name=findViewById(R.id.getName);
        Intent intent=getIntent();
        number.setText(intent.getStringExtra("number"));
        name.setText(intent.getStringExtra("name"));
    }
}
