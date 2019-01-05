package com.example.archek.gravitymvp.truemvp.contracts;

import com.example.archek.gravitymvp.truemvp.utils.net.Mock;

import java.util.List;

import io.reactivex.Observable;

public interface MainContract {
    /*interfaces for mvp*/
    interface view{
        void setMocks(List <Mock> mocks);

    }
    interface presenter extends Presenter<view>{

    }

    interface model {
        Observable<List<Mock>> getMocks();
    }
}
