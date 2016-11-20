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
    Call<List<Event>> getMovies();

    @GET("theater")
    Call<EventResponse> getPlays();

    @GET("music")
    Call<EventResponse> getConcerts();
}
