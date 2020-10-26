package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class bookAdapter extends BaseAdapter {
    Context context;//上下文变量
    List<book> list=new ArrayList<book>();
    class ViewHoder{//优化2，封装，减少重复绑定  回收复用
        ImageView imageView;
        TextView textView;
    }


    public bookAdapter(Context context,List<book> list){
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
        ViewHoder hoolder;

        if(convertView==null){//优化1，避免重复初始化
            convertView= LayoutInflater.from(context).inflate(R.layout.boolitemlayou,parent,false);

            hoolder=new ViewHoder();//2+
            hoolder.imageView=convertView.findViewById(R.id.booimg);
            hoolder.textView=convertView.findViewById(R.id.bookname);
            convertView.setTag(hoolder);//存储到上下文中
        }else{
            hoolder=(ViewHoder) convertView.getTag();//获取
        }
        //convertView= LayoutInflater.from(context).inflate(R.layout.boolitemlayou,parent,false);
        //ImageView bookim=convertView.findViewById(R.id.booimg);
        //TextView bookn=convertView.findViewById(R.id.bookname);
        book book1=list.get(position);
        //bookim.setImageResource(book1.getBookimg());
        ///bookn.setText(book1.getBookname());
        hoolder.imageView.setImageResource(book1.getBookimg());
        hoolder.textView.setText(book1.getBookname());
        return convertView;
    }
}

