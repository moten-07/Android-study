package com.example.class17_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class content extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        imageView=findViewById(R.id.imageView2);
        int s=getIntent().getIntExtra("img",0);
        imageView.setBackgroundResource(s);
    }
}
