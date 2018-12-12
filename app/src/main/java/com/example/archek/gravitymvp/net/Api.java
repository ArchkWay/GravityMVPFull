package com.example.archek.gravitymvp.net;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Api {//interface with  get quary

    @GET("bins/vk6qe")
        Call<List <Mock>> getMocks();


}
