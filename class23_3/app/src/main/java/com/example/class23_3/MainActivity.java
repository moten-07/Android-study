package com.example.class23_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Goods>list=new ArrayList<>();
    int [] GoodsImg={R.mipmap.i1,R.mipmap.i2,R.mipmap.i3};
    String [] GoodsName={};
    String [] buttomText={};
    MyAdapter myAdapter=new MyAdapter(this,list);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listView.setAdapter(myAdapter);
    }
    public void init(){
        listView=findViewById(R.id._dycn);
        GoodsName=getResources().getStringArray(R.array.goodsName);
        buttomText=getResources().getStringArray(R.array.buttomText);
        for (int i=0;i<GoodsName.length;i++){
            Goods Goodsitem=new Goods(GoodsImg[i%(GoodsImg.length)],GoodsName[i%(GoodsName.length)],buttomText[i%(buttomText.length)]);
            list.add(Goodsitem);
        }
    }
}
