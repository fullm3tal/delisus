package com.example.dakaku.delisus.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dakaku on 18/3/18.
 */
public class TotalDaily implements Parcelable {
    public TotalDaily() {
    }

    @SerializedName("ENERC_KCAL")
    @Expose
    private DietMeasurement eNERCKCAL;
    @SerializedName("FAT")
    @Expose
    private DietMeasurement fAT;
    @SerializedName("FASAT")
    @Expose
    private DietMeasurement fASAT;
    @SerializedName("CHOCDF")
    @Expose
    private DietMeasurement cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    private DietMeasurement fIBTG;
    @SerializedName("PROCNT")
    @Expose
    private DietMeasurement pROCNT;
    @SerializedName("CHOLE")
    @Expose
    private DietMeasurement cHOLE;
    @SerializedName("NA")
    @Expose
    private DietMeasurement nA;
    @SerializedName("CA")
    @Expose
    private DietMeasurement cA;
    @SerializedName("MG")
    @Expose
    private DietMeasurement mG;
    @SerializedName("K")
    @Expose
    private DietMeasurement k;
    @SerializedName("FE")
    @Expose
    private DietMeasurement fE;
    @SerializedName("ZN")
    @Expose
    private DietMeasurement zN;
    @SerializedName("P")
    @Expose
    private DietMeasurement p;
    @SerializedName("VITA_RAE")
    @Expose
    private DietMeasurement vITARAE;
    @SerializedName("VITC")
    @Expose
    private DietMeasurement vITC;
    @SerializedName("THIA")
    @Expose
    private DietMeasurement tHIA;
    @SerializedName("RIBF")
    @Expose
    private DietMeasurement rIBF;
    @SerializedName("NIA")
    @Expose
    private DietMeasurement nIA;
    @SerializedName("VITB6A")
    @Expose
    private DietMeasurement vITB6A;
    @SerializedName("FOLDFE")
    @Expose
    private DietMeasurement fOLDFE;
    @SerializedName("VITB12")
    @Expose
    private DietMeasurement vITB12;
    @SerializedName("VITD")
    @Expose
    private DietMeasurement vITD;
    @SerializedName("TOCPHA")
    @Expose
    private DietMeasurement tOCPHA;
    @SerializedName("VITK1")
    @Expose
    private DietMeasurement vITK1;


    protected TotalDaily(Parcel in) {
        eNERCKCAL = in.readParcelable(DietMeasurement.class.getClassLoader());
        fAT = in.readParcelable(DietMeasurement.class.getClassLoader());
        fASAT = in.readParcelable(DietMeasurement.class.getClassLoader());
        cHOCDF = in.readParcelable(DietMeasurement.class.getClassLoader());
        fIBTG = in.readParcelable(DietMeasurement.class.getClassLoader());
        pROCNT = in.readParcelable(DietMeasurement.class.getClassLoader());
        cHOLE = in.readParcelable(DietMeasurement.class.getClassLoader());
        nA = in.readParcelable(DietMeasurement.class.getClassLoader());
        cA = in.readParcelable(DietMeasurement.class.getClassLoader());
        mG = in.readParcelable(DietMeasurement.class.getClassLoader());
        k = in.readParcelable(DietMeasurement.class.getClassLoader());
        fE = in.readParcelable(DietMeasurement.class.getClassLoader());
        zN = in.readParcelable(DietMeasurement.class.getClassLoader());
        p = in.readParcelable(DietMeasurement.class.getClassLoader());
        vITARAE = in.readParcelable(DietMeasurement.class.getClassLoader());
        vITC = in.readParcelable(DietMeasurement.class.getClassLoader());
        tHIA = in.readParcelable(DietMeasurement.class.getClassLoader());
        rIBF = in.readParcelable(DietMeasurement.class.getClassLoader());
        nIA = in.readParcelable(DietMeasurement.class.getClassLoader());
        vITB6A = in.readParcelable(DietMeasurement.class.getClassLoader());
        fOLDFE = in.readParcelable(DietMeasurement.class.getClassLoader());
        vITB12 = in.readParcelable(DietMeasurement.class.getClassLoader());
        vITD = in.readParcelable(DietMeasurement.class.getClassLoader());
        tOCPHA = in.readParcelable(DietMeasurement.class.getClassLoader());
        vITK1 = in.readParcelable(DietMeasurement.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(eNERCKCAL, flags);
        dest.writeParcelable(fAT, flags);
        dest.writeParcelable(fASAT, flags);
        dest.writeParcelable(cHOCDF, flags);
        dest.writeParcelable(fIBTG, flags);
        dest.writeParcelable(pROCNT, flags);
        dest.writeParcelable(cHOLE, flags);
        dest.writeParcelable(nA, flags);
        dest.writeParcelable(cA, flags);
        dest.writeParcelable(mG, flags);
        dest.writeParcelable(k, flags);
        dest.writeParcelable(fE, flags);
        dest.writeParcelable(zN, flags);
        dest.writeParcelable(p, flags);
        dest.writeParcelable(vITARAE, flags);
        dest.writeParcelable(vITC, flags);
        dest.writeParcelable(tHIA, flags);
        dest.writeParcelable(rIBF, flags);
        dest.writeParcelable(nIA, flags);
        dest.writeParcelable(vITB6A, flags);
        dest.writeParcelable(fOLDFE, flags);
        dest.writeParcelable(vITB12, flags);
        dest.writeParcelable(vITD, flags);
        dest.writeParcelable(tOCPHA, flags);
        dest.writeParcelable(vITK1, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TotalDaily> CREATOR = new Creator<TotalDaily>() {
        @Override
        public TotalDaily createFromParcel(Parcel in) {
            return new TotalDaily(in);
        }

        @Override
        public TotalDaily[] newArray(int size) {
            return new TotalDaily[size];
        }
    };

    public DietMeasurement geteNERCKCAL() {
        return eNERCKCAL;
    }

    public DietMeasurement getfAT() {
        return fAT;
    }

    public DietMeasurement getfASAT() {
        return fASAT;
    }

    public DietMeasurement getcHOCDF() {
        return cHOCDF;
    }

    public DietMeasurement getfIBTG() {
        return fIBTG;
    }

    public DietMeasurement getpROCNT() {
        return pROCNT;
    }

    public DietMeasurement getcHOLE() {
        return cHOLE;
    }

    public DietMeasurement getnA() {
        return nA;
    }

    public DietMeasurement getcA() {
        return cA;
    }

    public DietMeasurement getmG() {
        return mG;
    }

    public DietMeasurement getK() {
        return k;
    }

    public DietMeasurement getfE() {
        return fE;
    }

    public DietMeasurement getzN() {
        return zN;
    }

    public DietMeasurement getP() {
        return p;
    }

    public DietMeasurement getvITARAE() {
        return vITARAE;
    }

    public DietMeasurement getvITC() {
        return vITC;
    }

    public DietMeasurement gettHIA() {
        return tHIA;
    }

    public DietMeasurement getrIBF() {
        return rIBF;
    }

    public DietMeasurement getnIA() {
        return nIA;
    }

    public DietMeasurement getvITB6A() {
        return vITB6A;
    }

    public DietMeasurement getfOLDFE() {
        return fOLDFE;
    }

    public DietMeasurement getvITB12() {
        return vITB12;
    }

    public DietMeasurement getvITD() {
        return vITD;
    }

    public DietMeasurement gettOCPHA() {
        return tOCPHA;
    }

    public DietMeasurement getvITK1() {
        return vITK1;
    }
}
