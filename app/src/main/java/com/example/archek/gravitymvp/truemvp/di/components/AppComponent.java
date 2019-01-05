package com.example.archek.gravitymvp.truemvp.di.components;


import com.example.archek.gravitymvp.truemvp.di.moduls.MvpModule;
import com.example.archek.gravitymvp.truemvp.models.MainModel;
import com.example.archek.gravitymvp.truemvp.presenters.MainPresenter;
import com.example.archek.gravitymvp.truemvp.views.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MvpModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(MainPresenter presenter);
    void inject(MainModel model);
}
