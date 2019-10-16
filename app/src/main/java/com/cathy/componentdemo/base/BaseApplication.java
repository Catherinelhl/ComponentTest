package com.cathy.componentdemo.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDexApplication;

import com.cathy.componentdemo.BuildConfig;
import com.xiaojinzi.component.Component;
import com.xiaojinzi.component.anno.ModuleAppAnno;
import com.xiaojinzi.component.application.IComponentApplication;
import com.xiaojinzi.component.impl.application.ModuleManager;

@ModuleAppAnno()
public class BaseApplication extends MultiDexApplication
implements IComponentApplication {
    @NonNull
    private Application application;
    @Override
    public void onCreate() {
        super.onCreate();
        // init
        Component.init(this, BuildConfig.DEBUG);
        // register other business Modules
        ModuleManager.getInstance().registerArr("app","Module1");
        if (BuildConfig.DEBUG) {
            // `Component` can check your hostAndPath and name of Interceptor is repeat or not
            // so please add follow code when BuildConfig.DEBUG is true
            ModuleManager.getInstance().check();
        }
    }

    @Override
    public void onCreate(@NonNull Application app) {
       this.application = app;
    }

    @Override
    public void onDestroy() {

    }
}
