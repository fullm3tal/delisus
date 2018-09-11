package com.example.dakaku.delisus.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dakaku on 17/3/18.
 */

public class Recipe implements Parcelable {

    public Recipe() {
    }

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


    protected Recipe(Parcel in) {
        uri = in.readString();
        label = in.readString();
        image = in.readString();
        source = in.readString();
        url = in.readString();
        shareAs = in.readString();
        if (in.readByte() == 0) {
            yield = null;
        } else {
            yield = in.readFloat();
        }
        dietLabels = in.createStringArrayList();
        healthLabels = in.createStringArrayList();
        if (in.readByte() == 0) {
            calories = null;
        } else {
            calories = in.readFloat();
        }
        if (in.readByte() == 0) {
            totalWeight = null;
        } else {
            totalWeight = in.readFloat();
        }
        totalNutrients = in.readParcelable(TotalNutrients.class.getClassLoader());
        totalDaily = in.readParcelable(TotalDaily.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uri);
        dest.writeString(label);
        dest.writeString(image);
        dest.writeString(source);
        dest.writeString(url);
        dest.writeString(shareAs);
        if (yield == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(yield);
        }
        dest.writeStringList(dietLabels);
        dest.writeStringList(healthLabels);
        if (calories == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(calories);
        }
        if (totalWeight == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(totalWeight);
        }
        dest.writeParcelable(totalNutrients, flags);
        dest.writeParcelable(totalDaily, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

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