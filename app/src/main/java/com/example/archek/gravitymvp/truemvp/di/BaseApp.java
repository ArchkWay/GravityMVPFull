package com.example.archek.gravitymvp.truemvp.di;

import android.app.Application;
import android.content.Context;

import com.example.archek.gravitymvp.truemvp.di.components.AppComponent;
import com.example.archek.gravitymvp.truemvp.di.components.DaggerAppComponent;
import com.example.archek.gravitymvp.truemvp.di.moduls.MvpModule;


public class BaseApp extends Application {
    private AppComponent appComponent;

    public AppComponent getInjector() {
        if(appComponent == null){
            appComponent = DaggerAppComponent
                    .builder()
                    .mvpModule(new MvpModule(this))
                    .build();
        }
        return appComponent;
    }
    public static BaseApp get(Context ctx){
            return (BaseApp)ctx.getApplicationContext();
    }
}
