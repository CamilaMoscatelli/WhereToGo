package com.example.grupo8webir.WhereToGo.api;

import android.content.pm.LauncherApps;

import com.example.grupo8webir.WhereToGo.model.Event;
import com.example.grupo8webir.WhereToGo.model.EventResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Camila on 14/11/2016.
 */

public interface ApiInterface {
    @GET("movies")
    Call<List<Event>> getMovies(@Query("q[date_eq]") String date,
                                @Query("q[hour_gt]") Integer hour,
                                @Query("q[price_cents_lteq]") Integer price);

    @GET("theater")
    Call<List<Event>> getPlays(@Query("antel_q[date_eq]") String dateAntel,
                               @Query("antel_q[hour_gt]") Integer hourAntel,
                               @Query("antel_q[max_price_cents_lteq]") Integer priceAntel,
                               @Query("movie_q[date_eq]") String dateMovie,
                               @Query("movie_q[hour_gt]") Integer hourMovie,
                               @Query("movie_q[max_price_cents_lteq]") Integer priceMovie);

    @GET("music")
    Call<List<Event>> getConcerts(@Query("q[date_eq]") String date,
                                  @Query("q[hour_gt]") Integer hour,
                                  @Query("q[max_price_cents_lteq]") Integer price);
}
