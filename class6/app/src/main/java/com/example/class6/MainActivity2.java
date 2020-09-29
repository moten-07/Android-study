package com.example.class6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    public Button but,but2;
    public EditText username2,password2;

    public void initial(){
        but=findViewById(R.id.zhuce);
        but2=findViewById(R.id.forzero);
        username2=findViewById(R.id.username2);
        password2=findViewById(R.id.password2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zhuce:

                String name=username2.getText().toString();
                String pass=password2.getText().toString();

//                User i=new User(name,pass);
                User2 i=new User2(name,pass);

                if((name!=null && !(name.equals("")) )&&( pass!=null && !(pass.equals("")) )){
                    Intent intent=new Intent(MainActivity2.this,MainActivity3.class);

                    // intent.putExtra("username2",name);
                    // intent.putExtra("password2",pass);
                    //startActivity(intent);

                    intent.putExtra("user",i);

                    startActivityForResult(intent,3);//带返回值的
                }else{
                    Toast.makeText(MainActivity2.this,"用户名或密码不能为空！",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.forzero:
                username2.setText(null);
                password2.setText(null);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        initial();
        but.setOnClickListener(this);
        but2.setOnClickListener(this);
        username2.setOnClickListener(this);
        password2.setOnClickListener(this);
    }

    //获取回传数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 3:
                switch (resultCode){
                    case 3:
                    String newname=data.getStringExtra("name");//取出回传数据
                    username2.setText(newname);
                    break;
                }
                break;
        }
    }


}
