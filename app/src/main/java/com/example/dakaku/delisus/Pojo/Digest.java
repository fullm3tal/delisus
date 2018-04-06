package com.example.dakaku.delisus.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dakaku on 18/3/18.
 */

public class Digest {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("schemaOrgTag")
    @Expose
    private String schemaOrgTag;
    @SerializedName("total")
    @Expose
    private Float total;
    @SerializedName("hasRDI")
    @Expose
    private Boolean hasRDI;
    @SerializedName("daily")
    @Expose
    private Float daily;
    @SerializedName("unit")
    @Expose
    private String unit;

    public Digest() {
    }

    public String getLabel() {
        return label;
    }

    public String getTag() {
        return tag;
    }

    public String getSchemaOrgTag() {
        return schemaOrgTag;
    }

    public Float getTotal() {
        return total;
    }

    public Boolean getHasRDI() {
        return hasRDI;
    }

    public Float getDaily() {
        return daily;
    }

    public String getUnit() {
        return unit;
    }



}
