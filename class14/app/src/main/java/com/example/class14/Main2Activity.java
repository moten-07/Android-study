package com.example.class14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    //文件存储plus
    EditText userName,password;
    Button button;
    CheckBox checkBox;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userStr=userName.getText().toString();
                String passStr=password.getText().toString();
                if (userStr.equals("admin") && passStr.equals("aaa")){
                    if (checkBox.isChecked()){
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putBoolean("checkBox",true);
                        editor.putString("name",userStr);
                        editor.putString("pass",passStr);
                        editor.apply();//把缓存数据写入apply()和commint()都是写入，后者有返回值
                    }
                    Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                    startActivity(intent);
                    }else{
                        Toast.makeText(Main2Activity.this,"errror!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void init(){
        userName=findViewById(R.id.username);
        password=findViewById(R.id.password);
        checkBox=findViewById(R.id.checkBox);
        button=findViewById(R.id.but2);
        sp=getSharedPreferences("usernamePlus",MODE_PRIVATE);//只有这种模式哟
        boolean flag=sp.getBoolean("checkBox",false);
        if (flag){
            checkBox.setChecked(true);
            userName.setText(sp.getString("name",""));
            password.setText(sp.getString("pass",""));
        }else{
            checkBox.setChecked(false);
        }
    }
}
