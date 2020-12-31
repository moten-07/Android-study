package com.example.class15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener{
    SQLiteDatabase db;
    EditText bname,author,price,page;
    Button add,del,up;
    List<Book> list = new ArrayList<Book>();
    RecyclerView Bookset;
    MyAdapter adapter;
    LinearLayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db=LitePal.getDatabase();
        init();
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())){
            case R.id.button3:
                Book book=new Book();
                String name=bname.getText().toString();
                String au=author.getText().toString();
                double pr=new Double(price.getText().toString());
                int pa=new Integer(page.getText().toString());
                book.setBookname(name);
                book.setAuthor(au);
                book.setPage(pa);
                book.setPrice(pr);
                book.save();
                list=search();
                adapter.notifyItemInserted(list.size()-1);
                break;
            case R.id.button5:

                break;
            case R.id.button4:
                LitePal.deleteAll(Book.class,"price<?","300");
                break;
        }
    }
    private  List<Book> search(){
        return LitePal.findAll(Book.class);
    }
    private  void init(){
//        String path=db.getPath();
//        Log.d("data",path);
        bname=findViewById(R.id.editText);
        author=findViewById(R.id.editText4);
        price=findViewById(R.id.editText5);
        page=findViewById(R.id.editText6);

        add=findViewById(R.id.button3);
        del=findViewById(R.id.button4);
        up=findViewById(R.id.button5);

        add.setOnClickListener(this);
        del.setOnClickListener(this);
        up.setOnClickListener(this);

        Bookset=findViewById(R.id.booklist);
        search();
        manager=new LinearLayoutManager(this);
        adapter= new MyAdapter(list,null);

        Bookset.setLayoutManager(manager);
        Bookset.setAdapter(adapter);

    }
}
