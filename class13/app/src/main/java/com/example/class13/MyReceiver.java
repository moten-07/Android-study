package com.example.class13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        /*
        String phone1=getResultData();      // 获取拨打的电话号码
        phone1=phone1.replace("-","");
        SharedPreferences sp=context.getSharedPreferences("config",0);
        String phone=sp.getString("phone","");
        if (phone1.equals(phone)){
            setResultData(null);
        }
         */
        Toast.makeText(context,"receiver1",Toast.LENGTH_SHORT).show();
    }
}
