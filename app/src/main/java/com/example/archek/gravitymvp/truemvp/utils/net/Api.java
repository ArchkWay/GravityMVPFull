package com.example.archek.gravitymvp.truemvp.utils.net;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;


public interface Api {//interface with  get quary

    @GET("bins/vk6qe")
    Observable<List<Mock>> getMocks();


}
