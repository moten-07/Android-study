package com.example.class19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUpActivity extends AppCompatActivity {
    EditText username,password;
    Button signup;
    MyHelpter helpter;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username=findViewById(R.id.editText1);
        password=findViewById(R.id.editText2);
        signup=findViewById(R.id.signup);
        helpter=new MyHelpter(this,"usertor.db",null,1);
        database=helpter.getWritableDatabase();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                String pass=password.getText().toString();
                Cursor cursor=database.query("userinfo",new String[]{"username"},"username=?",new String []{name},null,null,null);
                if(cursor.moveToFirst()){
                    Toast.makeText(signUpActivity.this,"用户名已存在",Toast.LENGTH_SHORT).show();
                    username.setText("");
                }else{
                    ContentValues values=new ContentValues();
                    values.put("username",name);
                    values.put("userpass",pass);
                    long id = database.insert("userinfo",null,values);
                    if(id>0){
                        Toast.makeText(signUpActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        username.setText("");
                        password.setText("");
                    }
                }
            }
        });
    }
}
