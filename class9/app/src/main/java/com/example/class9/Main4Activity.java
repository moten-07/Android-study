package com.example.class9;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TimePicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
   Button but1,but2,but3,but4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        but1=findViewById(R.id.button1);
        but2=findViewById(R.id.button2);
        but3=findViewById(R.id.button3);
        but4=findViewById(R.id.button4);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                AlertDialog.Builder builder=new AlertDialog.Builder(Main4Activity.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("警告");
                builder.setMessage("error!");
                builder.setCancelable(false);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
            case R.id.button2:
                ProgressDialog progressDialog=new ProgressDialog(Main4Activity.this);
                progressDialog.setTitle("下载进度:");
                progressDialog.setMessage("正在下载……");
                progressDialog.show();
                break;
            case R.id.button3:
                DatePickerDialog datePickerDialog=new DatePickerDialog(Main4Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                },2020,10,19);
                datePickerDialog.show();
                break;
            case R.id.button4:
                TimePickerDialog timePickerDialog=new TimePickerDialog(Main4Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    }
                },11,50,true);
                timePickerDialog.show();
                break;
        }
    }
}
