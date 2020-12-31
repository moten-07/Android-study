package com.example.class21;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button but1,but2;
    ImageView img;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1=findViewById(R.id.Button1);
        but2=findViewById(R.id.Button2);
        img=findViewById(R.id.imageView);



        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Button1:
                File file=new File(getExternalCacheDir(),"image.jpg");
                try {
                    if (file.exists()){
                        // 已有,删了
                        file.delete();
                    }
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT<24){
                    // 低于Android7.0
                    uri=Uri.fromFile(file);
                }else{
                    uri= FileProvider.getUriForFile(MainActivity.this,"com.example.class21.provider",file);
                }
                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                startActivityForResult(intent,1);
                break;
            case R.id.Button2:
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,new String []{Manifest.permission.WRITE_EXTERNAL_STORAGE},2);
                }else{
                    openAlum();
                }
                break;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED);
                break;
        }
    }
    private void openAlum(){
        Intent intent=new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    // 拍摄成功，将拍摄的照片转化为bitmap,不是requestCode
                    try {
                        Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                        img.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                if(Build.VERSION.SDK_INT>19){
                    String path = handleImgUri(data);
                    Bitmap bitmap=BitmapFactory.decodeFile(path);
                    img.setImageBitmap(bitmap);
                }
                break;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String handleImgUri(Intent data){
        // 处理图片的路径
        Uri imag=data.getData();
        String path="";
        if(DocumentsContract.isDocumentUri(MainActivity.this,imag)){
            String docId=DocumentsContract.getDocumentId(imag);
            if("com.android.providers.media.documents".equals(imag.getAuthority())){
                Log.d("id",docId);
                String id=docId.split(":")[1];
                String selection=MediaStore.Images.Media._ID+"="+id;
                path=getImagPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }else if("com.android.providers.media.downloads.documenrs".equals(imag.getAuthority())){
                Uri uri= ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
                path=getImagPath(uri,null);
            }

        }else if("content".equalsIgnoreCase(imag.getScheme())){
            path=getImagPath(imag,null);
        }else if("File".equalsIgnoreCase(imag.getScheme())){
            path=imag.getPath();
        }
        return path;
    }
    private String getImagPath(Uri uri,String selection){
        String path="";
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        if (cursor!=null && cursor.moveToFirst()){
            path=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        }
        return path;
    }
}
