package com.example.class9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView textView;
    RadioButton RB;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.TV1);
        radioGroup=findViewById(R.id.RG1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /**/
                switch (checkedId){
                    case R.id.RB1:
                        RB=findViewById(R.id.RB1);
                        break;
                    case R.id.RB2:
                        RB=findViewById(R.id.RB2);
                        break;
                    case R.id.RB3:
                        RB=findViewById(R.id.RB3);
                        break;
                    case R.id.RB4:
                        RB=findViewById(R.id.RB4);
                        break;
                }
                /**/
                //RB=findViewById(checkedId);
                textView.setText(RB.getText().toString());
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}
