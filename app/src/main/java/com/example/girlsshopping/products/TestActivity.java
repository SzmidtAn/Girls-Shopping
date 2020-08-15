package com.example.girlsshopping.products;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.girlsshopping.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestActivity extends AppCompatActivity {
    Button btn_save;
    ImageView img;
    private static final String image_url="https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/demo.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlay);
        img=(ImageView)findViewById(R.id.image_view);
        Glide.with(this)
                .load(image_url)
                .into(img);
        btn_save=(Button)findViewById(R.id.save_btn);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fileOutputStream=null;
                File file=getdisc();
                if (!file.exists() && !file.mkdirs())
                {
                    Toast.makeText(getApplicationContext(),"sorry can not make dir",Toast.LENGTH_LONG).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyymmsshhmmss");
                String date=simpleDateFormat.format(new Date());
                String name="img"+date+".jpeg";
                String file_name=file.getAbsolutePath()+"/"+name; File new_file=new File(file_name);
                try {
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(img,img.getWidth(),img.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(getApplicationContext(),"sucses", Toast.LENGTH_LONG).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                catch
                (FileNotFoundException e) {

                } catch (IOException e) {

                } refreshGallary(file);
            } private void refreshGallary(File file)
            { Intent i=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                i.setData(Uri.fromFile(file)); sendBroadcast(i);
            }
            private File getdisc(){
                File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                return new File(file,"My Image");
            } });
    }
    private static Bitmap viewToBitmap(View view, int widh, int hight)
    {
        Bitmap bitmap=Bitmap.createBitmap(widh,hight, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap); view.draw(canvas);
        return bitmap;
    }




}