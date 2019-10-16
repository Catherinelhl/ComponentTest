package com.cathy.componentdemo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cathy.componentdemo.R;
import com.cathy.componentdemo.databinding.ActivitySecondBinding;
import com.xiaojinzi.component.anno.RouterAnno;


@RouterAnno(
        host = "app",
        path = "second"
)
public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding activitySecondBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activitySecondBinding = DataBindingUtil.setContentView(this,R.layout.activity_second);
       activitySecondBinding.tvContent.setText("this is second activity");
    }



}
