package com.example.class16;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class signin extends AppCompatActivity implements View.OnClickListener{
    //登录
    AutoCompleteTextView username2;
    EditText password3;
    Button SI,NO2;
    static final List<String> names=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        init();
    }
    private void init(){
        username2=findViewById(R.id.username2);
        password3=findViewById(R.id.password3);
        SI=findViewById(R.id.buttonSI);
        NO2=findViewById(R.id.buttonNO2);

        SI.setOnClickListener(this);
        NO2.setOnClickListener(this);

        username2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if ((!hasFocus)){
                    String name=username2.getText().toString();
                    if (!names.contains(name)){names.add(name);}
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSI:
                List <User> list=LitePal.where("username==?",username2.getText().toString()).find(User.class);
                if (list.contains(password3.getText().toString())){
                    startActivity(new Intent(signin.this,Main2Activity.class));
                }else{
                    Toast.makeText(signin.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonNO2:
                username2.setText("");
                password3.setText("");
                showAlertDialog();
                break;
        }
    }

    public void showAlertDialog(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(signin.this);
        dialog.setTitle("取消：");
        dialog.setMessage("是否返回注册页面");
        dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(signin.this,signup.class));
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }
}
