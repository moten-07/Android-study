package com.example.class14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    //文件存储
    EditText name;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.edit);
        button=findViewById(R.id.but);
        try {
            name.setText(readFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String conn=name.getText().toString();
                try {
                    whiterConn(conn);
                } catch (IOException e) {
                    e.printStackTrace();
                    name.setText("");
                }
            }
        });
    }
    //读取
    private String readFile() throws IOException {
        FileInputStream fin=openFileInput("username");
        StringBuffer buffer=new StringBuffer();
        BufferedReader reader=new BufferedReader(new InputStreamReader(fin));
        String conn=null;
        while((conn=reader.readLine())!=null){
            buffer.append(conn);
        }
        if (reader!=null){
            reader.close();
        }
        return buffer.toString();
    }
    //写入
    private void whiterConn(String conn) throws IOException {
        FileOutputStream fou=openFileOutput("username",MODE_PRIVATE);
        //MODE_PRIVATE：覆盖写；MODE_APPEND：追加写
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(fou));
        writer.write(conn);
        if(writer!=null){
            writer.close();
        }
    }

}
