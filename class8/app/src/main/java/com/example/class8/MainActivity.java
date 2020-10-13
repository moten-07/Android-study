package com.example.class8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    String [] citys={"zhuhai","zhongshang","zhengzhou","zhejiang","zhumadian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String[] citys2=getResources().getStringArray(R.array.citys);
        ArrayAdapter <String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,citys);
        ArrayAdapter adapter1=ArrayAdapter.createFromResource(this,R.array.citys,android.R.layout.simple_expandable_list_item_1);
//        ArrayAdapter <String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,citys2);

        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setCompletionHint("最近搜索");
        autoCompleteTextView.setThreshold(1);//设置补全弹出条件
        autoCompleteTextView.setAdapter(adapter1);//实现控件和适配器的绑定
        autoCompleteTextView.setDropDownHorizontalOffset(10);
        autoCompleteTextView.setDropDownHorizontalOffset(6);


        multiAutoCompleteTextView=findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
