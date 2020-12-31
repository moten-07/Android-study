package com.example.class25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class Main2Activity extends AppCompatActivity {
    ListView listView;
    List<NewsInfo> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_item);
        listView=findViewById(R.id.newset);
        asyncHttpConn( "http://10.0.2.2/NewsInfo3.json");
    }
    // Async
    private void asyncHttpConn(String url){
        // 创建AsyncHttpClient
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String date=new String(responseBody,"utf-8");
                    list=gsonMethod(date);
                    adapter=new MyAdapter(Main2Activity.this,list);
                    listView.setAdapter(adapter);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }



    private List<NewsInfo> gsonMethod(String data){
        Gson gson=new Gson();
        List<NewsInfo>list1=gson.fromJson(data,new TypeToken<List<NewsInfo>>(){}.getType());
        return list1;
    }

}
