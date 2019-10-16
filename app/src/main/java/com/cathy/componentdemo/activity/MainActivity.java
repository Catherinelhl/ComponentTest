package com.cathy.componentdemo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.cathy.componentdemo.R;
import com.cathy.componentdemo.databinding.ActivityMainBinding;
import com.xiaojinzi.component.impl.Router;
import com.xiaojinzi.component.impl.RouterResult;
import com.xiaojinzi.component.support.CallbackAdapter;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
       initView();
    }

    private void initView(){
        activityMainBinding.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("onClick.....");
                jumbToSecondActivity();

            }
        });
    }

    /***
     * 跳转到另外一个界面
     */
    private void jumbToSecondActivity(){
                        Router.with()
                        .host("app")
                        .path("second")
                        .navigate();
    }

    /***
     * 跳转到另外一个ModuleActivity
     */
    private void jumbToAnotherModuleActivity(){
        Router.with(MainActivity.this)
                .hostAndPath("Module1/info")
                .putString("args","this is args context")
                .navigate(new CallbackAdapter(){
                    @Override
                    public void onSuccess(@NonNull RouterResult result) {
                        super.onSuccess(result);
                        System.out.println("onClick result:"+result);
                    }
                });
    }
}
