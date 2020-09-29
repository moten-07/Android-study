package com.example.class6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    public TextView uname2,pass2;
    public EditText newname;
    public Button butn;

    public void initial(){
        uname2=findViewById(R.id.uname2);
        pass2=findViewById(R.id.pass2);
        newname=findViewById(R.id.newName);
        butn=findViewById(R.id.buttonnew);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        initial();
        final Intent intent=getIntent();

        // String name=intent.getStringExtra("username2");
        // String pass=intent.getStringExtra("password2");

        //User u= (User) intent.getSerializableExtra("user");
        User2 u= (User2) intent.getParcelableExtra("user");//推荐

        String name=u.getName();
        String pass=u.getPassword();

        uname2.setText(name);
        pass2.setText(pass);

        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //数据回传
                Intent intent1=new Intent();
                String name=newname.getText().toString();
                intent1.putExtra("name",name);//储存数据
                setResult(3,intent1);//数据回传
                finish();
            }
        });


    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();//父类默认finish（），不能继承
        Intent intent1=new Intent();
        String name=newname.getText().toString();
        intent1.putExtra("name",name);
        setResult(3,intent1);
        finish();
    }
}
