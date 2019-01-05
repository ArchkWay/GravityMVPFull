package com.example.archek.gravitymvp.truemvp.utils.net;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.example.archek.gravitymvp.BuildConfig;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {

    Retrofit retrofit;

    public RetrofitProvider(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}