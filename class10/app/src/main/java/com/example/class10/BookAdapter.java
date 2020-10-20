package com.example.class10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends BaseAdapter {
    Context context;//上下文的变量
    List<Book> list=new ArrayList<Book>();

    public BookAdapter(Context context,List<Book> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        //长度
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        //返回对象
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        //返回ID，默认一致
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //难点
        convertView= LayoutInflater.from(context).inflate(R.layout.bookitemlayout,parent,false);
        ImageView bookim=convertView.findViewById(R.id.Bookimg);
        TextView bookn=convertView.findViewById(R.id.Bookname);
        Book book1=list.get(position);
        bookim.setImageResource(book1.getBookimg());
        bookn.setText(book1.getBookname());
        return convertView;
    }
}
