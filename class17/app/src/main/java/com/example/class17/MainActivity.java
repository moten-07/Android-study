package com.example.class17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager manager=getSupportFragmentManager();
        final FragmentTransaction transaction=manager.beginTransaction();
        RightFragment fragment=new RightFragment();
        transaction.add(R.id.Right_layout,fragment);
        transaction.commit();

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               anotherFragment anotherFragment=new anotherFragment();
               FragmentTransaction transaction1=manager.beginTransaction();
               transaction1=manager.beginTransaction();
               transaction1.replace(R.id.Right_layout,anotherFragment);
               transaction1.commit();
            }
        });

    }
}
