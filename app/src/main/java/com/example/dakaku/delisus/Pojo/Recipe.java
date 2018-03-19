package com.example.dakaku.delisus.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dakaku on 17/3/18.
 */

public class Recipe {

    @SerializedName("uri")
    @Expose
    private String uri;

    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("shareAs")
    @Expose
    private String shareAs;

    @SerializedName("yield")
    @Expose
    private Float yield;

    @SerializedName("dietLabels")
    @Expose
    private List<String> dietLabels = null;

    @SerializedName("healthLabels")
    @Expose
    private List<String> healthLabels = null;

    @SerializedName("cautions")
    @Expose
    private List<Object> cautions = null;

    @SerializedName("calories")
    @Expose
    private Float calories;

    @SerializedName("totalWeight")
    @Expose
    private Float totalWeight;

    @SerializedName("totalNutrients")
    @Expose
    private TotalNutrients totalNutrients;

    @SerializedName("totalDaily")
    @Expose
    private TotalDaily totalDaily;

    @SerializedName("digest")
    @Expose
    private List<Digest> digest = null;

    public String getUri() {
        return uri;
    }

    public String getLabel() {
        return label;
    }

    public String getImage() {
        return image;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public String getShareAs() {
        return shareAs;
    }

    public Float getYield() {
        return yield;
    }

    public List<String> getDietLabels() {
        return dietLabels;
    }

    public List<String> getHealthLabels() {
        return healthLabels;
    }

    public List<Object> getCautions() {
        return cautions;
    }

    public Float getCalories() {
        return calories;
    }

    public Float getTotalWeight() {
        return totalWeight;
    }

    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public TotalDaily getTotalDaily() {
        return totalDaily;
    }

    public List<Digest> getDigest() {
        return digest;
    }
}