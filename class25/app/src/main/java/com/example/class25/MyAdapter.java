package com.example.class25;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<NewsInfo>list;
    public MyAdapter(Context context,List<NewsInfo>list){
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
        ViewHolder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.activity_main,null);
            holder=new ViewHolder();
            holder.smartImageView=convertView.findViewById(R.id.icon);
            holder.title=convertView.findViewById(R.id.title);
            holder.content=convertView.findViewById(R.id.content);
            holder.comment=convertView.findViewById(R.id.number);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        NewsInfo info=list.get(position);
        holder.smartImageView.setImageUrl(info.getIcon());
        holder.title.setText(info.getTitle());
        holder.title.setTextColor(convertView.getResources().getColor(R.color.titlcolor));
        holder.content.setText(info.getContent());
        holder.content.setTextColor(convertView.getResources().getColor(R.color.infocolor));
        switch (info.getType()){
            case 1:
                holder.comment.setText("评论："+info.getComment());
                holder.comment.setTextColor(convertView.getResources().getColor(R.color.infocolor));
                break;
            case 2:
                holder.comment.setText("专题");
                holder.comment.setTextColor(convertView.getResources().getColor(R.color.type2color));
                break;
            case 3:
                holder.comment.setText("LIVE");
                holder.comment.setTextColor(convertView.getResources().getColor(R.color.type3color));
                break;
        }
        return convertView;
    }

    class ViewHolder{
        SmartImageView smartImageView;
        TextView title, content, comment;
    }
}
