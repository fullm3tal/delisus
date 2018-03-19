package com.example.dakaku.delisus.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dakaku on 19/3/18.
 */

public class DietMeasurement {


    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("quantity")
    @Expose
    private Float quantity;

    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Float getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }


}
