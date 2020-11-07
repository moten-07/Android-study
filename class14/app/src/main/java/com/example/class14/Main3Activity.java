package com.example.class14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.xml.validation.Validator;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    MyOpenHelper myOpenHelper;
    EditText bname,author,price,page;
    Button add,del,up;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }

    private  void init(){
        myOpenHelper=new MyOpenHelper(this,"bookstroe.db",null,1);
        bname=findViewById(R.id.bookname);
        author=findViewById(R.id.author);
        price=findViewById(R.id.price);
        page=findViewById(R.id.editText6);

        add=findViewById(R.id.add);
        del=findViewById(R.id.delete);
        up=findViewById(R.id.button5);
        db=myOpenHelper.getReadableDatabase();
    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.add:
                 String bn=bname.getText().toString();
                 String ba=author.getText().toString();
                 double bpr=new Double(price.getText().toString());
                 int bpa=new Integer(page.getText().toString());

                 ContentValues values=new ContentValues();
                 values.put("bookname",bn);
                 values.put("author",ba);
                 values.put("price",bpr);
                 values.put("page",bpa);
                 long i=db.insert("book",null,values);
                 if (i>0){
                     Toast.makeText(Main3Activity.this,"OK",Toast.LENGTH_SHORT).show();
                 }
                 //插入
                 break;
             case R.id.delete:
                 //删除
                 break;
             case R.id.button5:
                 String bn2=bname.getText().toString();
                 String ba2=author.getText().toString();
                 double bpr2=new Double(price.getText().toString());
                 double bpa2=new Double(page.getText().toString());
                     //更新
                 break;
         }
    }
}
