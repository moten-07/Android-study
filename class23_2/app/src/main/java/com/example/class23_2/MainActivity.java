package com.example.class23_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("number",editText1.getText().toString());
                intent.putExtra("name",editText2.getText().toString());
                startActivity(intent);
            }
        });
    }
    private void init(){
        editText1=findViewById(R.id.phonenumber);
        editText2=findViewById(R.id.nametext);
        button=findViewById(R.id.button);
    }
}
