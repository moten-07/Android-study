package com.example.class8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Spinner spinner,spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.provice,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setDropDownVerticalOffset(35);
        spinner.setDropDownHorizontalOffset(10);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //被选择时
                ArrayAdapter adapter1=null;
                switch (position){
                    case 0:
                        adapter1=ArrayAdapter.createFromResource(Main2Activity.this,R.array.hcitys,android.R.layout.simple_spinner_item);
                        break;
                    case 1:
                        adapter1=ArrayAdapter.createFromResource(Main2Activity.this,R.array.gditys,android.R.layout.simple_spinner_item);
                        break;
                    case 2:
                        adapter1=ArrayAdapter.createFromResource(Main2Activity.this,R.array.hbitys,android.R.layout.simple_spinner_item);
                        break;
                    case 3:
                        adapter1=ArrayAdapter.createFromResource(Main2Activity.this,R.array.hnitys,android.R.layout.simple_spinner_item);
                        break;
                    default:
                        break;
                }
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter1);
                spinner2.setDropDownVerticalOffset(35);
                spinner2.setDropDownHorizontalOffset(10);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //什么都不选--
            }
        });
    }
}
