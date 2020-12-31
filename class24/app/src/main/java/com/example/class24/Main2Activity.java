package com.example.class24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {
    Button button;
    TextView content;
    URL url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=findViewById(R.id.button);
        content=findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendHttpUrl();
                sendokHttp();
            }
        });
    }
    private void sendHttpUrl(){         // 原生的
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    url = new URL("https://developer.android.google.cn/");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
                    connection.setRequestMethod("POST");
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    out.writeBytes("username=admin&password=123456");
                    connection.setConnectTimeout(8000);     // 超时……
                    connection.setReadTimeout(6000);
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuffer conn = new StringBuffer();
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        conn.append(line);
                    }
                    Message message = new Message();
                    message.what = 123;
                    message.obj = conn;

                    handler.sendMessage(message);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();   // 启动新线程
    }
    private void sendokHttp(){      // https://github.com/square/okhttp
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("https://developer.android.google.cn/").build();  // 创建请求
                    Response response=client.newCall(request).execute();                                        // 执行请求
                    Message message=new Message();
                    message.what=123;
                    message.obj=response.body().string();
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    class MyHandler extends Handler{
        WeakReference<Main2Activity> myActivity;
        public MyHandler(Main2Activity activity){
            myActivity=new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Main2Activity activity=myActivity.get();    // 获取主线程
            if (activity!=null){
                if(msg.what==123){
                    String ss=msg.obj.toString();
                    content.setText(ss);
                }
            }else{
                return;
            }
        }
    }
    MyHandler handler=new MyHandler(this);
}
