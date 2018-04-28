package com.kwon.rest_prac.application;

import android.app.Application;

import com.kwon.rest_prac.network.NetworkService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by niceguy on 2018-03-21.
 */

public class ApplicationController extends Application{
    private static ApplicationController instance = new ApplicationController();
    private NetworkService networkService;

    public static ApplicationController getInstance(){
        return instance;
    }
    public NetworkService getNetworkService(){
        return networkService;
    }
    private ApplicationController(){
    }

    @Override
    public void onCreate(){
        super.onCreate();
        ApplicationController.instance = this;
        buildService();
    }

    public void buildService(){
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl("http://13.124.254.99:3303/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        networkService = retrofit.create(NetworkService.class);
    }
}
