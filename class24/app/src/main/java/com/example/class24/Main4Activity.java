package com.example.class24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main4Activity extends AppCompatActivity {
    List <versionObject> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        connECTokhttp();
    }
    private void connECTokhttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url="http://10.0.2.2/get_data.json";
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url(url).build();
                try {
                    Response response=client.newCall(request).execute();
                    String datastr=response.body().string();
                    Message message=new Message();
                    message.what=1;
                    message.obj=datastr;
                    handler.sendMessage(message);
                    // JSON数据解析

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private List<versionObject> jsonObjectMethod(String data) throws JSONException {
        JSONArray jsonArray=new JSONArray(data);
        List<versionObject> setobj=new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            versionObject item=new versionObject();
            String id=jsonObject.getString("id");
            String name=jsonObject.getString("name");
            String version=jsonObject.getString("version");
            item.setId(id);
            item.setName(name);
            item.setVersion(version);
            setobj.add(item);
        }
        return setobj;
    }

    private List<versionObject>gsonMethod(String date){
        Gson gson=new Gson();
        List<versionObject> lists=gson.fromJson(date,new TypeToken<List<versionObject>>(){}.getType());
        // 单条数据直接类名.class就行
        return lists;
    }



    class MyHandler extends Handler{
        WeakReference<Main4Activity> myActivity;
        public MyHandler(Main4Activity activity){
            myActivity=new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Main4Activity activity=myActivity.get();
            if(activity!=null){
                String data=(String)msg.obj;
                try {
                    // list=jsonObjectMethod(data);
                    list=gsonMethod(data);
                    for(versionObject i:list){
                        Log.i("id",i.getId());
                        Log.i("name",i.getName());
                        Log.i("version",i.getVersion());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                return;
            }
        }
    }
    MyHandler handler=new MyHandler(this);
}
