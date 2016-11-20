package com.example.grupo8webir.WhereToGo.api;

import android.util.Log;

import org.json.*;
import com.example.grupo8webir.WhereToGo.model.Event;
import com.example.grupo8webir.WhereToGo.ui.TabFragment;

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

    public void getMovies() {
        ApiInterface apiService = RestClient.getClient().create(ApiInterface.class);

        Call<List<Event>> call = apiService.getMovies();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                List<Event> movies = response.body();
                TabFragment.reloadData((ArrayList<Event>) movies);
                Log.d("", "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Log.e("", t.toString());
            }
        });

    }

    public void getPlays() throws JSONException {

    }

    public void getConcerts() throws JSONException {

    }
}
