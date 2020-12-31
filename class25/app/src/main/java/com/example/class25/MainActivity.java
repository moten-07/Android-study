package com.example.class25;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<NewsInfo> list;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_item);
        listView=findViewById(R.id.newset);
        okHttpConn();
    }

    private void okHttpConn(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url("http://10.0.2.2/NewsInfo3.json").build();
                try {
                    Response response=client.newCall(request).execute();
                    String data=response.body().string();
                    Message message=new Message();
                    message.what=123;
                    message.obj=gsonMethod(data);
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private List<NewsInfo> gsonMethod(String data){
        Gson gson=new Gson();
        List<NewsInfo>list1=gson.fromJson(data,new TypeToken<List<NewsInfo>>(){}.getType());
        return list1;
    }


    class MyHandler extends Handler {
        WeakReference<MainActivity> myActivity;
        public MyHandler(MainActivity activity){
            myActivity=new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            MainActivity activity=myActivity.get();
            if(activity!=null){
                if(msg.what==123){
                    list=(List<NewsInfo>)msg.obj;
                    adapter=new MyAdapter(MainActivity.this,list);
                    listView.setAdapter(adapter);
                }
            }else{
                return;
            }
        }
    }
    MyHandler handler=new MyHandler(this);
}
