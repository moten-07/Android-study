package com.example.class7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int cruntprogress=0;
    SeekBar seekBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d("MainActivity",this.toString());
        Log.d("MainActivity",getTaskId()+"");

        Button button=findViewById(R.id.button1);
        progressBar=findViewById(R.id.progressBar);
        seekBar1=findViewById(R.id.seekBar);

        progressBar.setMax(100);        //设置最大进度
        progressBar.setProgress(50);    //设置当前进度,环形的设置不了，只能是0
        cruntprogress=progressBar.getProgress();//获取进度条的当前进度
        Log.d("start",cruntprogress+"");

        seekBar1.setMax(100);
        seekBar1.setProgress(30);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //调戏进度条时……
                Toast.makeText(MainActivity.this,"当前进度是"+progress,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //开始调戏进度条时……
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //结束调戏进度条时……

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,Main2Activity.class);//1.
//                startActivity(intent);//1
                if(cruntprogress<100){
                    cruntprogress+=10;
                    Log.d("current",cruntprogress+"");
                    progressBar.setProgress(cruntprogress);

                }else{
                    progressBar.setVisibility(View.GONE);
                    //设为不可见，或INVISIBLE(但占用空间，只是看不见)
                    //VISIBLE:可见
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity",this.toString()+"\treturn A");
    }
}
