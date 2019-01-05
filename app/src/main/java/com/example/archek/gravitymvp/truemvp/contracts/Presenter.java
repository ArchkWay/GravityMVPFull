package com.example.archek.gravitymvp.truemvp.contracts;

public interface Presenter<V> {
    void attachView(V mvpView);
    void detachView();
}
