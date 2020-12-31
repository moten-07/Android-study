package com.example.class22;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    MyAdapter adapter;
    List<Music>list;
    MediaPlayer player=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.musicList);
        list=getMusic();
        adapter=new MyAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music music=list.get(position);
                if(player.isPlaying()){
                    player.reset();
                }
                try {
                    player.setDataSource(music.getPath());
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 获取歌曲的方法
    private List<Music> getMusic(){
        List<Music>musicSet=new ArrayList<>();
        Cursor cursor=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,MediaStore.Audio.Media.IS_MUSIC);
        if(cursor!=null){
            while (cursor.moveToNext()){
                Music music=new Music();
                String name=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String artist=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                String path=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                long duration=cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                music.setName(name);
                music.setArtist(artist);
                music.setPath(path);
                music.setDuration(duration);
                musicSet.add(music);
            }
        }
        return musicSet;
    }
}
