package com.example.class15;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public List<Book> list;
    recyclerItemSelectLinster linster;
    public MyAdapter(List<Book> list ,recyclerItemSelectLinster linster){
        this.list=list;
        this.linster=linster;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView bookname,author,price,page;
        int position;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookname=itemView.findViewById(R.id.bookname);
            author=itemView.findViewById(R.id.author);
            price=itemView.findViewById(R.id.price);
            page=itemView.findViewById(R.id.page);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clink(v);
                }
            });
        }
        public void clink(View view){

            linster.onRecyclerViewItemClickListener(this,view,position);
        }


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bookitem,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Book book=list.get(position);
        holder.bookname.setText(book.getBookname());
        holder.author.setText(book.getAuthor());
        holder.price.setText(book.getPrice()+"");
        holder.page.setText(book.getPage()+"");
        holder.position=position;
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

}
