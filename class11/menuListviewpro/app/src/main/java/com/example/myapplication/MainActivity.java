package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview1);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //第一参数是菜单项组的id值
        //第二表参数是当组中菜单项在id
        //第三个参数是菜单项胡排序方式，0代表按照添加顺序排序
        //第四个菜单项的名称
       // getMenuInflater().inflate(R.menu.menuoption,menu);
        SubMenu subMenu=menu.addSubMenu("子菜单1");
        subMenu.add("zc1");
        subMenu.add("zc2");
        menu.add(0,0,0,"菜单项1");
        menu.add(0,1,0,"菜单项2");
        menu.add(0,2,0,"菜单项3");
        menu.add(0,3,0,"菜单项4");
        menu.add(0,4,0,"菜单项5");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case 0:
               Toast.makeText(MainActivity.this,item.getTitle()+"",Toast.LENGTH_SHORT).show();
           case 3:
               break;
       }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v==textView){
            menu.setHeaderTitle("上下文菜单");
            menu.setHeaderIcon(R.mipmap.ic_launcher);
            menu.add("菜单项1");
            menu.add("菜单项2");
            menu.add("菜单项3");
        }
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        return super.onContextItemSelected(item);
    }
}
