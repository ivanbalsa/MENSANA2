package com.example.menssana;

import com.example.menssana.ForoPack.TitularesForo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfazAPIForo {

    @GET("top-headlines?category=health&language=en")
    Call<TitularesForo> getTitulares(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("everything?language=en")
    Call<TitularesForo> getBusqueda(
            @Query("q") String q,
            @Query("apiKey") String apiKey
    );


}
