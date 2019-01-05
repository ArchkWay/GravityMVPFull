package com.example.archek.gravitymvp.truemvp.di.moduls;

import android.content.Context;


import com.example.archek.gravitymvp.truemvp.contracts.MainContract;
import com.example.archek.gravitymvp.truemvp.models.MainModel;
import com.example.archek.gravitymvp.truemvp.presenters.MainPresenter;
import com.example.archek.gravitymvp.truemvp.utils.net.RetrofitProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MvpModule {
    /*modules injectors*/
    private final Context context;
    public MvpModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    MainContract.presenter provideMainContractPresenter(Context context){
        return new MainPresenter(context);
    }
    @Provides
    @Singleton
    MainContract.model provideMainContractModel(Context context){
        return new MainModel(context);
    }

    @Provides
    @Singleton
    RetrofitProvider provideRetrofit(){
        return new RetrofitProvider();
    }
}
