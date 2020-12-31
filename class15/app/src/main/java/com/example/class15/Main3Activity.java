package com.example.class15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
   MySqliteOpenHelper helper;
   SQLiteDatabase db;
   RecyclerView recyclerView;
   EditText bookname,author,price,page;
   Button insert,up,del;
    MyAdapter adapter;
    List<Book> list=new ArrayList<>();
    private recyclerItemSelectLinster linster=new recyclerItemSelectLinster() {
        @Override
        public void onRecyclerViewItemClickListener(MyAdapter.ViewHolder holder, View view, int pos) {
            holder.position=pos;
            Book book=list.get(pos);
            bookname.setText(book.getBookname());
            author.setText(book.getAuthor());
            price.setText(book.getPrice()+"");
            page.setText(book.getPage()+"");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        intitl();

    }

  private void intitl(){
        recyclerView=findViewById(R.id.booklist);
        bookname=findViewById(R.id.editText);
        author=findViewById(R.id.editText4);
        price=findViewById(R.id.editText5);
        page=findViewById(R.id.editText6);
        insert=findViewById(R.id.button3);
        del=findViewById(R.id.button4);
        up=findViewById(R.id.button5);
        insert.setOnClickListener(this);
        del.setOnClickListener(this);
        up.setOnClickListener(this);
      MyLineraManger manager=new MyLineraManger(this);
      recyclerView.setLayoutManager(manager);
      helper=new MySqliteOpenHelper(this,"bookstore.db",null,1);
      db=helper.getWritableDatabase();
      search();
      adapter=new MyAdapter(list,linster);
      recyclerView.setAdapter(adapter);


  }
  private List<Book> search(){
        list.clear();
      Cursor cursor=db.query("book",null,null,null,null,null,null);
      if(cursor.moveToFirst()){
          do{
              String name=cursor.getString(cursor.getColumnIndex("bookname"));
              String author=cursor.getString(cursor.getColumnIndex("author"));
              int page=cursor.getInt(cursor.getColumnIndex("page"));
              double price=cursor.getDouble(cursor.getColumnIndex("price"));
              Book book=new Book();
              book.setBookname(name);
              book.setAuthor(author);
              book.setPage(page);
              book.setPrice(price);
              list.add(book);
          }while(cursor.moveToNext());

      }
      return list;
  }
    @Override
    public void onClick(View v) {
        String name=bookname.getText().toString();
        String authorstr=author.getText().toString();
        int pages=new Integer(page.getText().toString());
        double prices=new Double(price.getText().toString());
        switch (v.getId()){
            case R.id.button3:
              Book book=new Book();
                ContentValues values=new ContentValues();
                values.put("bookname",name);
                values.put("author",authorstr);
                values.put("page",pages);
                values.put("price",prices);
                book.setBookname(name);
                book.setAuthor(authorstr);
                book.setPrice(prices);
                book.setPage(pages);

               long a= db.insert("book",null,values);
                // search();
                list.add(book);
                if(a>0){
                    Toast.makeText(Main3Activity.this,"插入成功",Toast.LENGTH_SHORT).show();
                }
               setnull();
                adapter.notifyItemInserted(list.size()-1);
                break;
            case R.id.button5:
                ContentValues values1=new ContentValues();
              //  values1.put("bookname",name);
                values1.put("author",authorstr);
                values1.put("page",pages);
                values1.put("price",prices);
                db.update("book",values1,"bookname=?",new String[]{name});
                search();
                adapter.notifyDataSetChanged();
                setnull();
                break;
            case R.id.button4:
                db.delete("book","bookname=?",new String[]{name});
                search();
                adapter.notifyDataSetChanged();
                setnull();
                break;
        }

    }
    private void setnull(){
        bookname.setText("");
        author.setText("");
        price.setText("");
        page.setText("");
    }

}
