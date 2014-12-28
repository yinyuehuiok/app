package com.yjf.note;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private List<Uri> imageList;
    private static int nowImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add_button = (Button)findViewById(R.id.add_picture);
        Button before_button = (Button)findViewById(R.id.before_picture);
        Button after_button = (Button)findViewById(R.id.after_picture);
        add_button.setOnClickListener(this);
        before_button.setOnClickListener(this);
        after_button.setOnClickListener(this);
        //初始化ImageView
        initImageLayout();
    }

    //初始化ImageView
    private void initImageLayout(){
        RelativeLayout imageLayout = (RelativeLayout)findViewById(R.id.cycle);
        TextView textView = new TextView(this);
        textView.setText("还没有图片，点击上传按钮添加");
        imageLayout.addView(textView);
        //初始化图片数据
        imageList = new ArrayList<Uri>();
        //初始化图片索引值
        nowImage = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // test dfsd
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode == 1){
           if(data != null){
               Uri imageUri = data.getData();
               System.out.println(imageUri.getPath());
               if(imageUri != null){
               }
           }
       }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.add_picture:
                startActivityForResult(new Intent(MainActivity.this,ButtonListActivity.class),1);
                break;
            case R.id.before_picture:getNextImage(0,nowImage);break;
            case R.id.after_picture:getNextImage(1,nowImage);break;
        }
    }
    //flag 1表示下一张，0表示上一张
    private void getNextImage(int flag,int id){
          if(flag == 1){
              if(imageList.size() == id){
                  Toast.makeText(this,"已经是最后一张了", Toast.LENGTH_SHORT).show();
              }else{
                  //返回下一张

              }
          }else{
              if(id == 0){
                  Toast.makeText(this.getApplicationContext(),"已经是第一张了", Toast.LENGTH_SHORT).show();
              }else{
                  //返回上一张

              }
          }
    }

}
