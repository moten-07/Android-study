package com.example.class23_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    List<Goods> list;
    Context context;

    public MyAdapter(Context context,List<Goods>list){
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
            convertView= LayoutInflater.from(context).inflate(R.layout.goods_item,null);
        }
        Goods goods=list.get(position);
        ImageView img=convertView.findViewById(R.id.img);
        TextView name=convertView.findViewById(R.id.getGoodsName);
        final Button button=convertView.findViewById(R.id.button);
        CheckBox checkBox=convertView.findViewById(R.id.checkBox);

        img.setImageResource(goods.getPhoto());
        name.setText(goods.getName());
        button.setText(goods.getButtonText());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,button.getText().toString(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{

                }
            }
        });
        return convertView;
    }
}
