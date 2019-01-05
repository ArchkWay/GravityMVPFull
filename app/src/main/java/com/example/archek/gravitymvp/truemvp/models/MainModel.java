package com.example.archek.gravitymvp.truemvp.models;

import android.content.Context;

import com.example.archek.gravitymvp.truemvp.contracts.MainContract;
import com.example.archek.gravitymvp.truemvp.di.BaseApp;
import com.example.archek.gravitymvp.truemvp.utils.net.Api;
import com.example.archek.gravitymvp.truemvp.utils.net.Mock;
import com.example.archek.gravitymvp.truemvp.utils.net.RetrofitProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainModel implements MainContract.model{
    /*get through retrofit mocks for further using -> provider -> view*/
    private final Api api;
    @Inject RetrofitProvider provider;

    public MainModel(Context context){
        BaseApp.get(context).getInjector().inject(this);
        api = provider.getApi();
    }

    @Override
    public Observable<List<Mock>> getMocks() {
        return api.getMocks().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
