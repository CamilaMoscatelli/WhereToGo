package com.example.grupo8webir.WhereToGo.api;

import org.json.*;
import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;

/**
 * Created by Camila on 23/10/2016.
 */
public class ComunicationManager {

    public void getAllEvents() throws JSONException {
        RestClient.get("events/all_events", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //TODO If the response is JSONObject instead of expected JSONArray
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                //TODO
            }
        });
    }

}
