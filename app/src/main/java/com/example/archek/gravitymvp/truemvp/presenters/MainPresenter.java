package com.example.archek.gravitymvp.truemvp.presenters;


import android.content.Context;

import com.example.archek.gravitymvp.truemvp.contracts.MainContract;
import com.example.archek.gravitymvp.truemvp.di.BaseApp;

import javax.inject.Inject;

public class MainPresenter implements MainContract.presenter{
    MainContract.view view;
    @Inject MainContract.model model;

    @Inject
    public MainPresenter(Context context){
        BaseApp.get(context).getInjector().inject(this);
    }

    /*getting mocks from Model*/
    @Override
    public void attachView(MainContract.view view) {
        this.view = view;
        model.getMocks().subscribe(view::setMocks);
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
