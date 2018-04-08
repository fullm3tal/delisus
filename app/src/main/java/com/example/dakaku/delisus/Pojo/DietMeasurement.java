package com.example.dakaku.delisus.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dakaku on 19/3/18.
 */

public class DietMeasurement implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label=null;

    @SerializedName("quantity")
    @Expose
    private Float quantity=0F;

    @SerializedName("unit")
    @Expose
    private String unit=null;

    public DietMeasurement() {
        this.label = "";
        this.quantity = 0F;
        this.unit = "";
    }

    public String getLabel() {
        return label;
    }

    public Float getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }


    protected DietMeasurement(Parcel in) {
        label = in.readString();
        if (in.readByte() == 0) {
            quantity = null;
        } else {
            quantity = in.readFloat();
        }
        unit = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
        if (quantity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(quantity);
        }
        dest.writeString(unit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DietMeasurement> CREATOR = new Creator<DietMeasurement>() {
        @Override
        public DietMeasurement createFromParcel(Parcel in) {
            return new DietMeasurement(in);
        }

        @Override
        public DietMeasurement[] newArray(int size) {
            return new DietMeasurement[size];
        }
    };


}
