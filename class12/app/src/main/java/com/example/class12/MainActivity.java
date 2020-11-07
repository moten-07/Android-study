package com.example.class12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText editText;
    Button button;
    List<Meg> list=new ArrayList<Meg>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        final MegAdapter adapter=new MegAdapter(list);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String con=editText.getText().toString();
                if (!con.equals("")){
                    Meg meg=new Meg(true,con);
                    list.add(meg);
                    adapter.notifyItemInserted(list.size()-1);//提醒适配器更新
                    editText.setText("");
                }
            }
        });

    }

    //数据初始化
    public void initDate(){
        Meg meg1=new Meg(false,"阿斯蒂芬规划局？");
        Meg meg2=new Meg(true,"法国红酒卡罗拉？");
        Meg meg3=new Meg(false,"没事了。");
        list.add(meg1);
        list.add(meg2);
        list.add(meg3);

        editText=findViewById(R.id.sendcontent);
        recyclerView=findViewById(R.id.Recy);
        button=findViewById(R.id.sendbutton);
    }
}
