package com.example.class7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Log.d("Main2Activity",this.toString());
        Log.d("Main2Activity",getTaskId()+"");
        Button button=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
//                Log.d("MainActity","B>C");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main2Activity",this.toString()+"\tdelete B");
    }
}
