package com.example.class13_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends MainActivity {
    public EditText name,pass;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editText1);
        pass=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namestr=name.getText().toString();
                String passstr=pass.getText().toString();
                if (namestr.equals("admin") && passstr.equals("12345")){
                    Intent intent=new Intent(LoginActivity.this,offineActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
