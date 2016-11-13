package com.example.grupo8webir.WhereToGo.api;

import com.loopj.android.http.*;

/**
 * Created by Camila on 23/10/2016.
 */
public class RestClient {

    private static final String BASE_URL = "http://where-to-go-be.herokuapp.com/api/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    private static final int TIMEOUT = 45000; // 45 seconds
    private static final int RETRIES = 0;

    public RestClient() {
        client.setTimeout(TIMEOUT);
        client.setMaxRetriesAndTimeout(RETRIES, TIMEOUT);
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler); //TODO probably not used
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
