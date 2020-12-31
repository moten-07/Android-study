package com.example.class22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;

public class Main3Activity extends AppCompatActivity {
    VideoView videoView;
    Button button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        videoView=findViewById(R.id.videoView);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        initVideo();
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!videoView.isPlaying()){
                    videoView.start();
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()){
                    videoView.pause();
//                    videoView.resume();
                }
            }
        });

    }
    private void initVideo(){
        String path = Environment.getExternalStorageDirectory().getPath();
        String path1=path+"/Pictures";
        File file=new File(path1,"视频三音乐列表的显示_2020121104750.mp4");
        videoView.setVideoPath(file.getPath());
    }
}
