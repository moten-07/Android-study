package com.example.class9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    CheckBox CB1,CB2,CB3,CB4;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView=findViewById(R.id.textView);
        CB1=findViewById(R.id.CB1);
        CB2=findViewById(R.id.CB2);
        CB3=findViewById(R.id.CB3);
        CB4=findViewById(R.id.CB4);

        CB1.setOnCheckedChangeListener(this);
        CB2.setOnCheckedChangeListener(this);
        CB3.setOnCheckedChangeListener(this);
        CB4.setOnCheckedChangeListener(this);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        CheckBox checkBox=(CheckBox) buttonView;
        String content=textView.getText().toString();
        if (isChecked){
            //偷懒的写法
           switch (checkBox.getId()){
               //选中时……
               case R.id.CB1:
               case R.id.CB2:
               case R.id.CB3:
               case R.id.CB4:
                   content+="  "+checkBox.getText().toString();
                   textView.setText(content);
                   break;
           }
           //content+="  "+checkBox.getText().toString();//追加值
           //textView.setText(content);//赋值
        }else{
            //取消选中时
            /*
            switch (checkBox.getId()){
                case R.id.CB1:
                case R.id.CB2:
                case R.id.CB3:
                case R.id.CB4:
                    content=content.replace("  "+checkBox.getText().toString(),"");
                    textView.setText(content);
                    break;
            }
            */
            //过度偷懒的写法，哈哈哈哈
            content=content.replace("  "+checkBox.getText().toString(),"");//内容替换为空串
            textView.setText(content);//赋值
        }
    }
}
