package com.example.class11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    List<book> list;
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text1);
            imageView=itemView.findViewById(R.id.imag1);
        }
    }
    public MyAdapter(List <book> list){
        this.list=list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {//绑定布局
        final View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        //2、实现对数据项控件的点击交互
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),viewHolder.textView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),viewHolder.imageView.getBackground().toString(),Toast.LENGTH_SHORT).show();
;            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder holder, int position) {
        //交互
        //1、完成数据的绑定
        //2、实现对数据项控件的点击交互
        book item=list.get(position);
        holder.textView.setText(item.getBookname());
        holder.imageView.setBackgroundResource(item.getBookimg());
       /* holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.textView.setText("kokodayo");
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
