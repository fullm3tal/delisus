package com.example.dakaku.delisus.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dakaku on 19/3/18.
 */

public class FoodData {

        @SerializedName("q")
        @Expose
        private String q;

        @SerializedName("from")
        @Expose
        private Integer from;

        @SerializedName("to")
        @Expose
        private Integer to;

        @SerializedName("more")
        @Expose
        private Boolean more;

        @SerializedName("count")
        @Expose
        private Integer count;

        @SerializedName("hits")
        @Expose
        private List<FoodApiHits> hits = null;

    public String getQ() {
        return q;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }

    public Boolean getMore() {
        return more;
    }

    public Integer getCount() {
        return count;
    }

    public List<FoodApiHits> getHits() {
        return hits;
    }

}
