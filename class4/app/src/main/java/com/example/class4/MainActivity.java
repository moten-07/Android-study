package com.example.class4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView,textsum;//显示文本,结果文本
    Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;//数字按键
    Button add,minu,mult,divi,equal,clear,back;//符号按键
    float num=0;//运算数字
    String test;//显示的运算式

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        init();
        seton();
    }

    private  void init() {//控件绑定
        textView = findViewById(R.id.textView);
        textsum = findViewById(R.id.textView1s2);
        num0 = findViewById(R.id.num0);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);

        add = findViewById(R.id.add);
        minu = findViewById(R.id.minu);
        mult = findViewById(R.id.mult);
        divi = findViewById(R.id.divi);
        equal = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);
        back = findViewById(R.id.back);
    }
    public void seton(){//控件监听
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        add.setOnClickListener(this);
        minu.setOnClickListener(this);
        mult.setOnClickListener(this);
        divi.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.num0:
                test+="0";
                break;
            case R.id.num1:
                test+="1";
                break;
            case R.id.num2:
                test+="2";
                break;
            case R.id.num3:
                test+="3";
                break;
            case R.id.num4:
                test+="4";
                break;
            case R.id.num5:
                test+="5";
                break;
            case R.id.num6:
                test+="6";
                break;
            case R.id.num7:
                test+="7";
                break;
            case R.id.num8:
                test+="8";
                break;
            case R.id.num9:
                test+="9";
                break;
            case R.id.add:
                test+="+";
                break;
            case R.id.minu:
                test+="-";
                break;
            case R.id.mult:
                test+="*";
                break;
            case R.id.divi:
                test+="/";
                break;
            case R.id.clear:
                test="";
                break;
            case R.id.back:
                String str = test.substring(0, test.length()-1);
                test = str;
                break;
            case R.id.equal:
                test=" ";
                test=textView.getText().toString();
                textsum.setText(""+getNum(test));//运算
                break;
        }
        textView.setText(test);
    }

    private float getNum(String test){
        String str1=test.replace("+","-");//加号替换为减号，原数据不变
        String [] s=str1.split("-");//通过减号分割数据
        for(String s1:s){
//            Log.d("tag",s1);
            int count=1;//记录数组长度
            for(int i=0;i<s1.length();i++){
                if(s1.contains("*")||s1.contains("/")){
                    a:for(int j =i+1;j<s1.length();j++){
                        char c =str1.charAt(j);
                        if(c=='*'||c=='/'){
                            break a;
                        }else{
                            count++;
                        }
                    }
                    String s2 =str1.substring(i,i+count);
                    float d = Float.parseFloat(s2);
                    if(i==0){
                        num = d;
                    }else{
                        char c1 = str1.charAt(i-1);
                        if(c1=='*'){
                           num*=d;
                        }else if(c1=='/'){
                            //如果除数为0，直接返回null;
                            if(d == 0)
                                return Float.parseFloat(null);
                            num/=d;
                        }
                    }
                    i+=count+1;
                }
                s1= s1.replace(s1, num+"");
            }
        }
        //进行加减运算
        for(int i =0;i<test.length();i++){
            int count =1;
            a:for(int j=i+1;j<test.length();j++){
                char c = test.charAt(j);
                if(c=='+'||c=='-'){
                    break a;
                }else{
                    count++;
                }
            }
            String s3= test.substring(i,i+count);
            float d2 =Float.parseFloat(s3);
            if(i==0){
                num = d2;
            }else{
                char c = test.charAt(i-1);
                if(c=='+'){
                    num+=d2;
                }else if(c=='-'){
                    num-=d2;
                }
            }
            i+=count;
        }
        return num;
    }
}
