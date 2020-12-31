package com.example.class27;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<weather> list;

    public MyAdapter(Context context,List<weather> list){
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
        viewHolder holder;
        if(convertView==null){
            holder=new viewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item,null);
            holder.city=convertView.findViewById(R.id.city);
            holder.weather=convertView.findViewById(R.id.weather);
            holder.temp=convertView.findViewById(R.id.temp);
            holder.wind=convertView.findViewById(R.id.wind);
            holder.pm=convertView.findViewById(R.id.pm);
            holder.cloud=convertView.findViewById(R.id.cloud);
            convertView.setTag(holder);
        }else{
            holder=(viewHolder)convertView.getTag();
        }
        weather weather=list.get(position);
        holder.city.setText(weather.getName());
        holder.weather.setText(weather.getWeather());
        holder.temp.setText(weather.getTemp());
        holder.wind.setText(weather.getWind());
        holder.pm.setText(weather.getPm());
        switch (weather.getWeather()){
            case "晴":
                holder.cloud.setImageAlpha(R.drawable.sun);
                break;
            case "晴转多云":
                holder.cloud.setImageAlpha(R.drawable.cloud_sun);
                break;
            case "多云":
                holder.cloud.setImageAlpha(R.drawable.clouds);
                break;
        }
        return convertView;
    }

    class viewHolder{
        TextView city,weather,temp,wind,pm;
        ImageView cloud;
    }
}

