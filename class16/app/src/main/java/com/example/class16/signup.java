package com.example.class16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class signup extends AppCompatActivity implements View.OnClickListener{
    //注册页面
    EditText username,password,password2;
    Button SU,NO;
    TextView textView;
    User user=new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
    }
    private void init(){
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        password2=findViewById(R.id.password2);
        SU=findViewById(R.id.buttonSU);
        NO=findViewById(R.id.buttonNO);
        textView=findViewById(R.id.textViewout);
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            //焦点追踪
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    String Username=username.getText().toString();
                    List<User> names =LitePal.where("username==?",Username).find(User.class);
                    Log.d("size",names.size()+"");
                    if (names.size()!=0){
                        textView.setText("用户已存在！");
                        textView.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        username.addTextChangedListener(new TextWatcher() {
            //文本改变监听
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //内容改变前
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //内容改变时
                textView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //内容改变后
            }
        });


        SU.setOnClickListener(this);
        NO.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSU:
                if (password.getText().toString().equals(password2.getText().toString())){
                    if(user.save()){
                        startActivity(new Intent(signup.this,signin.class));
                    }else {
                        Log.d("error","error");
                    }

                }else{
                    Toast.makeText(signup.this,"两次输入密码不一致",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonNO:
                username.setText("");
                password.setText("");
                password2.setText("");
                break;
        }
    }
}
