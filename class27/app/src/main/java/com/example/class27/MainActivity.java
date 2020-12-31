package com.example.class27;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView city,weather,temp,wind,pm;
    ImageView cloud;
    Toolbar toolbar;
    List<weather> list =new ArrayList<>();
//    MyAdapter adapter;
    String url="http://10.0.2.2/weather.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        okHttp();
    }

    private void init(){
        city=findViewById(R.id.city);
        weather=findViewById(R.id.weather);
        temp=findViewById(R.id.temp);
        wind=findViewById(R.id.wind);
        pm=findViewById(R.id.pm);
        cloud=findViewById(R.id.cloud);
        toolbar = findViewById(R.id.toolbar);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolmenu,menu);
        menu.add(0,0,0,"北京");
        menu.add(0,1,1,"上海");
        menu.add(0,2,2,"广州");
        for (int i=0;i<list.size();i++){
            menu.add(0,i,i,list.get(i).getName());
            Log.d("cirty",list.get(i).getName());
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"为您切换到第"+(item.getItemId()+1)+"个城市:"+list.get(item.getItemId()).getName(),Toast.LENGTH_SHORT).show();
        getWeatherInfo(item.getItemId());
        return true;
    }

    private  List<weather> gsonPare(String date){
        return new Gson().fromJson(date,new TypeToken<List<weather>>(){}.getType());
    }

    class MyHandler extends Handler{
        WeakReference<MainActivity> myActivity;
        public MyHandler(MainActivity mainActivity){
            myActivity=new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            MainActivity activity=myActivity.get();
            if(activity!=null){
                switch (msg.what){
                    case 123:
                        String con=msg.obj.toString();
                        list=gsonPare(con);
                        // 绑定第一条数据
                        city.setText(list.get(0).getName());
                        weather.setText(list.get(0).getWeather());
                        temp.setText(list.get(0).getTemp());
                        pm.setText("PM:"+list.get(0).getPm());
                        wind.setText("风力:"+list.get(0).getWind());
                        switch (list.get(0).getWeather()){
                            case "晴":
                                Glide.with(activity).load(R.drawable.sun).into(cloud);
                                break;
                            case "晴转多云":
                                Glide.with(activity).load(R.drawable.cloud_sun).into(cloud);
                                break;
                            case "多云":
                                Glide.with(activity).load(R.drawable.clouds).into(cloud);
                                break;
                        }
                        break;
                }
            }else{
                return;
            }

        }
    }
    MyHandler handler=new MyHandler(this);

    private void okHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url(url).build();
                Response response=null;
                try {
                    response=client.newCall(request).execute();
                    String ss=response.body().string();
                    Message message=new Message();
                    message.what=123;
                    message.obj=ss;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void getWeatherInfo(int index){
        city.setText(list.get(index).getName());
        weather.setText(list.get(index).getWeather());
        temp.setText(list.get(index).getTemp());
        pm.setText("PM:"+list.get(index).getPm());
        wind.setText("风力:"+list.get(index).getWind());
        int imgs=R.drawable.sun;
        switch (list.get(index).getWeather()){
            case "晴":
                imgs=R.drawable.sun;
                break;
            case "晴转多云":
                imgs=R.drawable.cloud_sun;
                break;
            case "多云":
                imgs=R.drawable.clouds;
                break;
        }
        Glide.with(MainActivity.this).load(imgs).into(cloud);

    }
}
