package com.example.class22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Music> list;
    public MyAdapter(Context context,List<Music> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.music_item,null);
        }
        Music music=list.get(position);
        TextView name=convertView.findViewById(R.id.textView);
        TextView artist=convertView.findViewById(R.id.textView2);
        TextView duration=convertView.findViewById(R.id.textView3);

        name.setText(music.getName());
        artist.setText(music.getArtist());
        duration.setText(strFormat(music.getDuration()));



        return convertView;
    }
    private String strFormat(long a){
        long muin=a/1000/60;
        long secods=a/1000%60;
        String secodsStr=""+secods;
        String muinStr=""+muin;
        if (secods<10){
            secodsStr="0"+secods;
        }
        if (muin<10){
            muinStr="0"+muin;
        }
        return muinStr+":"+secodsStr;
    }
}
