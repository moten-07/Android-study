package com.example.class18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout logo1,logo2,logo3,logo4;
    TextView text1,text2,text3,text4;
    ImageButton imgb1,imgb2,imgb3,imgb4;
    List<Fragment> list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        strart();
    }

    public void init(){
        logo1=findViewById(R.id.logo1);
        logo2=findViewById(R.id.logo2);
        logo3=findViewById(R.id.logo3);
        logo4=findViewById(R.id.logo4);

        text1=findViewById(R.id.textWe);
        text2=findViewById(R.id.textTx);
        text3=findViewById(R.id.textFi);
        text4=findViewById(R.id.textMe);

        imgb1=findViewById(R.id.imgButWe);
        imgb2=findViewById(R.id.imgButTx);
        imgb3=findViewById(R.id.imgButFi);
        imgb4=findViewById(R.id.imgButMe);

        logo1.setOnClickListener(this);
        logo2.setOnClickListener(this);
        logo3.setOnClickListener(this);
        logo4.setOnClickListener(this);

        imgb1.setOnClickListener(this);
        imgb2.setOnClickListener(this);
        imgb3.setOnClickListener(this);
        imgb4.setOnClickListener(this);

        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        text3.setOnClickListener(this);
        text4.setOnClickListener(this);

        list.add(new TopFragment());
        list.add(new TxFragment());
        list.add(new FiFragment());
        list.add(new MeFragment());

    }

    @Override
    public void onClick(View v) {
        strart();
        switch (v.getId()){
            case R.id.logo1:
            case R.id.textWe:
            case R.id.imgButWe:
                choose(0);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(0)).commit();
                break;
            case R.id.logo2:
            case R.id.textTx:
            case R.id.imgButTx:
                choose(1);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(1)).commit();
                break;
            case R.id.logo3:
            case R.id.textFi:
            case R.id.imgButFi:
                choose(2);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(2)).commit();
                break;
            case R.id.logo4:
            case R.id.textMe:
            case R.id.imgButMe:
                choose(3);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(3)).commit();
                break;
        }
    }
    public void strart(){
        imgb1.setImageDrawable(getResources().getDrawable(R.mipmap.weichat));
        imgb2.setImageDrawable(getResources().getDrawable(R.mipmap.tx));
        imgb3.setImageDrawable(getResources().getDrawable(R.mipmap.find));
        imgb4.setImageDrawable(getResources().getDrawable(R.mipmap.wo));
        text1.setTextColor(Color.parseColor("#ffffff"));
        text2.setTextColor(Color.parseColor("#ffffff"));
        text3.setTextColor(Color.parseColor("#ffffff"));
        text4.setTextColor(Color.parseColor("#ffffff"));
        choose(0);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,list.get(0)).commit();
    }

    public void choose(int i){
        switch (i){
            case 0:
                imgb1.setImageDrawable(getResources().getDrawable(R.mipmap.weichatpress));
                text1.setTextColor(Color.parseColor("#008000"));
                break;
            case 1:
                imgb2.setImageDrawable(getResources().getDrawable(R.mipmap.txpress));
                text2.setTextColor(Color.parseColor("#008000"));
                break;
            case 2:
                imgb3.setImageDrawable(getResources().getDrawable(R.mipmap.findpress));
                text3.setTextColor(Color.parseColor("#008000"));
                break;
            case 3:
                imgb4.setImageDrawable(getResources().getDrawable(R.mipmap.wopress));
                text4.setTextColor(Color.parseColor("#008000"));
                break;
        }
    }
}
