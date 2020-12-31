package com.example.class22;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button but1,but2,but3;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1=findViewById(R.id.button1);
        but2=findViewById(R.id.button2);
        but3=findViewById(R.id.button3);
//        player=MediaPlayer.create(this,R.raw.bigfish);
        try {
            initialMedia();
        } catch (IOException e) {
            e.printStackTrace();
        }
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
    }
    private void initialMedia() throws IOException {
        // 已知路径检索
        String path= Environment.getExternalStorageDirectory().getPath();
        // 获取外部存储目录的路径=》/sdcard
        String pathMedis=path+"/Pictures";
        Log.d("path",path);
        File file=new File(pathMedis,"青花瓷.mp3");
        player=new MediaPlayer();
        player.setDataSource(file.getPath());
        player.prepare(); // 这种方式必须prepare
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                if(!player.isPlaying()){
                    player.start();
                }
                break;
            case R.id.button2:
                if(player.isPlaying()){
                    player.pause();
                }
                break;
            case R.id.button3:
                if (player.isPlaying()){
//                    player.pause();
//                    player.stop();
                    player.reset();
                    try {
                        initialMedia();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
