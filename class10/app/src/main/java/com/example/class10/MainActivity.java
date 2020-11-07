package com.example.class10;

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
        textView=findViewById(R.id.text);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //创建选项菜单
        menu.add(0,0,0,"菜单项一");
        getMenuInflater().inflate(R.menu.menuoption,menu);//引用XML文件（‘睿智’编辑器，这也能乱标红），别管这句，上课时编辑器自己的问题
        //菜单项组的ID（保证唯一就行）、在当前组中菜单项的、排序方式，0代表默认、标题（或者引用XML文件对应的整型）
        //menu.add(0,1,0,"菜单项二");
        //menu.add(0,2,0,"菜单项三");
        menu.add(0,3,0,"菜单项四");
        menu.add(0,3,0,"菜单项五");
        //itemId重复不覆盖，但行为相同

        SubMenu subMenu=menu.addSubMenu("子菜单1");
        //创建子菜单
        subMenu.add("zc1");
        subMenu.add("zc2");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //菜单项单击
        switch (item.getItemId()){
            case 0:
                Toast.makeText(MainActivity.this,item.getTitle()+"",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item1:
                break;
            case R.id.item2:
                break;
            case 3:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //创建上下文菜单
        if(v==textView){
            menu.setHeaderTitle("上下文菜单");
            menu.setHeaderIcon(R.mipmap.ic_launcher);
            menu.add("菜单项一");
            menu.add("菜单项二");
            menu.add("菜单项三");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //上下文菜单项单击
        return super.onContextItemSelected(item);
    }
}
