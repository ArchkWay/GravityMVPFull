package com.example.archek.gravitymvp.mvp;


import android.support.annotation.NonNull;

import com.example.archek.gravitymvp.net.Api;
import com.example.archek.gravitymvp.net.Mock;
import com.example.archek.gravitymvp.net.RestApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GravityPresenter {

    private final View view;
    private final Api api = RestApi.createService(Api.class);


    public GravityPresenter( View view) {
        this.view = view;
    }

    public void loadMocks() {
        view.showProgress();
        Call <List <Mock>> call = api.getMocks();
        /*in background process are loading our mocks*/
        call.enqueue(new Callback<List <Mock>>() {
            @Override
            public void onResponse(@NonNull Call<List <Mock>> call, @NonNull Response<List <Mock>> response) {
                view.showMocks(response.body());
                view.hideProgress();
            }

            @Override
            public void onFailure(@NonNull Call <List <Mock>> call, @NonNull Throwable t) {
                view.showError("Error");
                view.hideProgress();
            }
        });
    }

    public interface View{
        void showMocks(List<Mock> mocks);
        void hideProgress();
        void showProgress();
        void showError(String error);
    }

}
