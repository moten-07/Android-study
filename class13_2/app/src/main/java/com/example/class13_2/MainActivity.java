package com.example.class13_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;
    class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setTitle("Error!");
            builder.setMessage("you are out!");
            builder.setCancelable(false);
            builder.setPositiveButton("OK?", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityControl.fishAll();
                    Intent intent1=new Intent(context,LoginActivity.class);
                    startActivity(intent1);
                }
            });
            builder.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityControl.addActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityControl.removeActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();//暂停状态
        if(receiver!=null){
            unregisterReceiver(receiver);
            receiver=null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter=new IntentFilter();
        filter.addAction("offline");
        receiver=new MyReceiver();
        registerReceiver(receiver,filter);
    }
}
