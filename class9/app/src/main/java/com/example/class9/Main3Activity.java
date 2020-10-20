package com.example.class9;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Main3Activity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button=findViewById(R.id.buttonO);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1、构建通知容器，创建一个NotificationCompat.Bulider对象
                NotificationCompat.Builder builder=new NotificationCompat.Builder(Main3Activity.this,"1");
                //2、对builder进行相关属性的设置（例如：图标、标题……）
                builder.setSmallIcon(R.mipmap.ic_launcher_round);//图标
                builder.setContentTitle("江南皮革厂倒闭了");//标题
                builder.setContentText("浙江温州、浙江温州，江南最大皮革厂倒闭了……");//内容
                builder.setAutoCancel(true);//设置自动取消

                Intent resultIntent=new Intent(Main3Activity.this,Main2Activity.class);
                TaskStackBuilder st=TaskStackBuilder.create(Main3Activity.this);
                st.addParentStack(Main2Activity.class);
                st.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent=st.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(resultPendingIntent);

                //3、创建NotificationManager和Notification对象
                NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            Notification notification=builder.build();
        //4、调用notify,发送通知
        manager.notify(1,notification);
    }
});
    }
}
