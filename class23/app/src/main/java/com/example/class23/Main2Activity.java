package com.example.class23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    private String [] setButtom={".","1","2","3","清空"
                                ,"?","4","5","6","0"
                                ,"!","7","8","9",","
                                ,"符","123","︺","中/英","换行"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
