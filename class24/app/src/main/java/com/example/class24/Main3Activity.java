package com.example.class24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main3Activity extends AppCompatActivity {
    EditText editText;
    Button button;
    ImageView content;
    String imgurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button2);
        content=findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendokHttp(editText.getText().toString());
//                editText.setText("");
                sendOkHttpXML();
            }
        });
    }
    private void sendokHttp(final String imgurl){      // https://github.com/square/okhttp
        this.imgurl=imgurl;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url(imgurl).build();  // 创建请求
                    Response response=client.newCall(request).execute();                                        // 执行请求
                    Bitmap bitmap= BitmapFactory.decodeStream(response.body().byteStream());
                    Message message=new Message();
                    message.what=1;
                    message.obj=bitmap;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void sendOkHttpXML(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url("http://10.0.2.2/get_data.xml").build();
                // 模拟器连接本地服务器地址：10.0.2.2
                // 夜神需要修改WLAN里面的WriedSSID,更改代理服务器主机名和端口，主机名可通过win+R》ipconfig获取，端口可通过netstat -a -n获取
                try {
                    Response response=client.newCall(request).execute();
                    String dataStream=response.body().string();
                    Message message=new Message();
                    String ss=XMLPull(dataStream);
                    message.what=123;
                    message.obj=ss;
                    handler.sendMessage(message);
                } catch (IOException | XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private String XMLPull(String content) throws XmlPullParserException, IOException {
        XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
        XmlPullParser xmlPullParser=factory.newPullParser();
        xmlPullParser.setInput(new StringReader(content));
        String id="",name="",version="",nameset="";
        int type=xmlPullParser.getEventType();
        while (type!=XmlPullParser.END_DOCUMENT){
            String typeName= xmlPullParser.getName();
            switch (type){
                case XmlPullParser.START_TAG:
                    if (typeName.equals("id")){
                        id=xmlPullParser.nextText();
                    }else if (typeName.equals("name")){
                        name=xmlPullParser.nextText();
                    }else if (typeName.equals("version")){
                        version=xmlPullParser.nextText();
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("app".equals(typeName)){
//                        Log.d("id",id);
//                        Log.d("name",name);
//                        Log.d("version",version);
                        nameset=nameset+id+" "+name+" "+version+"\n\t";
                    }
                    break;
            }
            type=xmlPullParser.next();
        }
        return nameset;
    }


    class MyHandler extends Handler{
        WeakReference<Main3Activity> myActivity;
        public MyHandler(Main3Activity activity){
            myActivity=new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Main3Activity activity=myActivity.get();    // 获取主线程
            if (activity!=null){
                if(msg.what==1){
                    Bitmap bitmap=(Bitmap)msg.obj;
                    content.setImageBitmap(bitmap);
                }else if(msg.what==123){
                    String ss=msg.obj.toString();
                    Log.d("file",ss);
                }
            }else{
                return;
            }
        }
    }
    MyHandler handler=new MyHandler(this);
}
