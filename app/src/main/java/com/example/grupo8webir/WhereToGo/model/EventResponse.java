package com.example.grupo8webir.WhereToGo.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Camila on 14/11/2016.
 */
//TODO I think this is not used
public class EventResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Event> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Event> getResults() {
        return results;
    }

    public void setResults(List<Event> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
