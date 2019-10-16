package com.cathy.module1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cathy.module1.R;
import com.xiaojinzi.component.anno.RouterAnno;

@RouterAnno(
        host = "Module1",
        path = "info")
public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Intent intent = getIntent();
        if (intent !=null){
            Bundle bundle=intent.getExtras();
            String args=bundle.getString("args");
            System.out.println("onClick args:"+args);
            ((TextView)findViewById(R.id.tv_content)).setText(args);

        }

    }
}
