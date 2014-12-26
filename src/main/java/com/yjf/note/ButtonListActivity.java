package com.yjf.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by Administrator on 2014/12/26 0026.
 */
public class ButtonListActivity extends Activity implements OnClickListener{

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_button);
        intent = getIntent();
       Button btn_photo = (Button)this.findViewById(R.id.photo_button);
       Button btn_picture = (Button)this.findViewById(R.id.picture_button);
       Button btn_off = (Button)this.findViewById(R.id.off_button);
    }

    @Override
    public void onClick(View view) {

    }
}
