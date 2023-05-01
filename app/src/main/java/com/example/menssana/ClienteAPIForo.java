package com.example.menssana;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteAPIForo {
    private static final String url = "https://newsapi.org/v2/";
    private static ClienteAPIForo clienteAPI;
    private static Retrofit retrofit;
    private ClienteAPIForo(){
        retrofit= new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized ClienteAPIForo getInstance(){
        if(clienteAPI == null){
            clienteAPI = new ClienteAPIForo();
        }
        return clienteAPI;
    }
    public InterfazAPIForo getApi(){
        return retrofit.create(InterfazAPIForo.class);
    }
}
