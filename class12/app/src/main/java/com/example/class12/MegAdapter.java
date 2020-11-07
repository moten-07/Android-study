package com.example.class12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MegAdapter extends RecyclerView.Adapter<MegAdapter.ViewHolder> {

    List<Meg> list;

    public MegAdapter(List<Meg> list){
        this.list=list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout,rightLayout;
        TextView sendmeg,remeg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftLayout=itemView.findViewById(R.id.LeftLayout);
            rightLayout=itemView.findViewById(R.id.RightLayout);
            sendmeg=itemView.findViewById(R.id.Sendmeg);
            remeg=itemView.findViewById(R.id.Receivmeg);
        }
    }

    @NonNull
    @Override
    public MegAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.megitem,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MegAdapter.ViewHolder holder, int position) {
        Meg meg=list.get(position);
        if (meg.getType()==Meg.TYPE_RECEIVE){
            holder.leftLayout.setVisibility(View.VISIBLE);//显示左泡泡
            holder.rightLayout.setVisibility(View.GONE);//隐藏右泡泡
            holder.remeg.setText(meg.getContent());
        }else if(meg.getType()==Meg.TYPE_SEND){//反着来
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.sendmeg.setText(meg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
