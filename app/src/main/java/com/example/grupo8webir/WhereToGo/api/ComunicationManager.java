package com.example.grupo8webir.WhereToGo.api;

import android.util.Log;

import org.json.*;
import com.example.grupo8webir.WhereToGo.model.Event;
import com.example.grupo8webir.WhereToGo.ui.TabFragmentMovies;
import com.example.grupo8webir.WhereToGo.ui.filtros;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Camila on 23/10/2016.
 */
public class ComunicationManager {

    private static ComunicationManager sInstance = null;

    public static ComunicationManager getInstance() {
        if (sInstance == null) {
            sInstance = new ComunicationManager();
        }

        return sInstance;
    }

    public void getMovies(String date, Integer hour, Integer price) {
        ApiInterface apiService = RestClient.getClient().create(ApiInterface.class);

        Call<List<Event>> call = apiService.getMovies(date, hour, price);
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                List<Event> movies = response.body();
                filtros.goToResultsIfLoaded("Movies", (ArrayList<Event>) movies);
                Log.d("", "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                filtros.goToResultsIfLoaded("Movies", new ArrayList<Event>());
                Log.e("", t.toString());
            }
        });
    }

    public void getPlays(String date, Integer hour, Integer price) {
        ApiInterface apiService = RestClient.getClient().create(ApiInterface.class);

        Call<List<Event>> call = apiService.getPlays(date, hour, price, date, hour, price);
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                List<Event> plays = response.body();
                filtros.goToResultsIfLoaded("Theatre", (ArrayList<Event>) plays);
                Log.d("", "Number of movies received: " + plays.size());
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                filtros.goToResultsIfLoaded("Theatre", new ArrayList<Event>());
                Log.e("", t.toString());
            }
        });
    }

    public void getConcerts(String date, Integer hour, Integer price) {
        ApiInterface apiService = RestClient.getClient().create(ApiInterface.class);

        Call<List<Event>> call = apiService.getConcerts(date, hour, price);
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                List<Event> concerts = response.body();
                filtros.goToResultsIfLoaded("Music", (ArrayList<Event>) concerts);
                Log.d("", "Number of movies received: " + concerts.size());
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                filtros.goToResultsIfLoaded("Music", new ArrayList<Event>());
                Log.e("", t.toString());
            }
        });
    }
}
