package com.example.dakaku.delisus.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dakaku on 18/3/18.
 */

public class TotalNutrients implements Parcelable {

    @SerializedName("ENERC_KCAL")
    @Expose
    private DietMeasurement eNERCKCAL;
    @SerializedName("FAT")
    @Expose
    private DietMeasurement fAT;
    @SerializedName("FASAT")
    @Expose
    private DietMeasurement fASAT;
    @SerializedName("FATRN")
    @Expose
    private DietMeasurement fATRN;
    @SerializedName("FAMS")
    @Expose
    private DietMeasurement fAMS;
    @SerializedName("FAPU")
    @Expose
    private DietMeasurement fAPU;
    @SerializedName("CHOCDF")
    @Expose
    private DietMeasurement cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    private DietMeasurement fIBTG;
    @SerializedName("SUGAR")
    @Expose
    private DietMeasurement sUGAR;
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

    @SerializedName("FOLFD")
    @Expose
    private DietMeasurement fOLFD;

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


    protected TotalNutrients(Parcel in) {
        eNERCKCAL = in.readParcelable(DietMeasurement.class.getClassLoader());
        fAT = in.readParcelable(DietMeasurement.class.getClassLoader());
        fASAT = in.readParcelable(DietMeasurement.class.getClassLoader());
        fATRN = in.readParcelable(DietMeasurement.class.getClassLoader());
        fAMS = in.readParcelable(DietMeasurement.class.getClassLoader());
        fAPU = in.readParcelable(DietMeasurement.class.getClassLoader());
        cHOCDF = in.readParcelable(DietMeasurement.class.getClassLoader());
        fIBTG = in.readParcelable(DietMeasurement.class.getClassLoader());
        sUGAR = in.readParcelable(DietMeasurement.class.getClassLoader());
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
        fOLFD = in.readParcelable(DietMeasurement.class.getClassLoader());
        vITB12 = in.readParcelable(DietMeasurement.class.getClassLoader());
        vITD = in.readParcelable(DietMeasurement.class.getClassLoader());
        tOCPHA = in.readParcelable(DietMeasurement.class.getClassLoader());
        vITK1 = in.readParcelable(DietMeasurement.class.getClassLoader());
    }

    public TotalNutrients() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(eNERCKCAL, flags);
        dest.writeParcelable(fAT, flags);
        dest.writeParcelable(fASAT, flags);
        dest.writeParcelable(fATRN, flags);
        dest.writeParcelable(fAMS, flags);
        dest.writeParcelable(fAPU, flags);
        dest.writeParcelable(cHOCDF, flags);
        dest.writeParcelable(fIBTG, flags);
        dest.writeParcelable(sUGAR, flags);
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
        dest.writeParcelable(fOLFD, flags);
        dest.writeParcelable(vITB12, flags);
        dest.writeParcelable(vITD, flags);
        dest.writeParcelable(tOCPHA, flags);
        dest.writeParcelable(vITK1, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TotalNutrients> CREATOR = new Creator<TotalNutrients>() {
        @Override
        public TotalNutrients createFromParcel(Parcel in) {
            return new TotalNutrients(in);
        }

        @Override
        public TotalNutrients[] newArray(int size) {
            return new TotalNutrients[size];
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

    public DietMeasurement getfATRN() {
        return fATRN;
    }

    public DietMeasurement getfAMS() {
        return fAMS;
    }

    public DietMeasurement getfAPU() {
        return fAPU;
    }

    public DietMeasurement getcHOCDF() {
        if(cHOCDF==null){
            cHOCDF=getDummy();
        }
        return cHOCDF;
    }

    public DietMeasurement getfIBTG() {
        if(fIBTG==null){
            fIBTG = getDummy();
        }
        return fIBTG;
    }

    public DietMeasurement getsUGAR() {
        if(sUGAR==null){
            sUGAR=getDummy();
        }
        return sUGAR;
    }

    public DietMeasurement getpROCNT() {
        if(pROCNT==null){
            pROCNT=getDummy();
        }
        return pROCNT;
    }

    public DietMeasurement getcHOLE() {
        if (cHOLE==null){
            cHOLE=getDummy();
        }
        return cHOLE;
    }

    public DietMeasurement getnA() {
        if(nA==null){
            nA=getDummy();
        }
        return nA;
    }

    public DietMeasurement getcA() {
        if (cA==null){
            cA=getDummy();
        }
        return cA;
    }

    public DietMeasurement getmG() {
        if (mG==null){
            mG=getDummy();
        }
        return mG;
    }

    public DietMeasurement getK() {
        if (k==null){
            k=getDummy();
        }
        return k;
    }

    public DietMeasurement getfE() {
        if (fE==null){
            fE=getDummy();
        }
        return fE;
    }

    public DietMeasurement getzN() {
        if (zN==null){
            zN=getDummy();
        }
        return zN;
    }

    public DietMeasurement getP() {
        if (p==null){
            p=getDummy();
        }
        return p;
    }

    public DietMeasurement getvITARAE() {
        if (vITARAE==null){
            vITARAE=getDummy();
        }
        return vITARAE;
    }

    public DietMeasurement getvITC() {
        if (vITC==null){
            vITC=getDummy();
        }
        return vITC;
    }

    public DietMeasurement gettHIA() {
        if (tHIA==null){
            tHIA=getDummy();
        }
        return tHIA;
    }

    public DietMeasurement getrIBF() {
        if (rIBF==null){
            rIBF=getDummy();
        }
        return rIBF;
    }

    public DietMeasurement getnIA() {
        if (nIA==null){
            nIA=getDummy();
        }
        return nIA;
    }

    public DietMeasurement getvITB6A() {
        if (vITB6A==null){
            vITB6A=getDummy();
        }
        return vITB6A;
    }

    public DietMeasurement getfOLDFE() {
        if (fOLDFE==null){
            fOLDFE=getDummy();
        }
        return fOLDFE;
    }

    public DietMeasurement getfOLFD() {
        if (fOLFD==null){
            fOLFD=getDummy();
        }
        return fOLFD;
    }

    public DietMeasurement getvITB12() {
        if (vITB12==null){
            vITB12=getDummy();
        }
        return vITB12;
    }

    public DietMeasurement getvITD() {
        if (vITD==null){
            vITD=getDummy();
        }
        return vITD;
    }

    public DietMeasurement gettOCPHA() {
        if (tOCPHA==null){
            tOCPHA=getDummy();
        }
        return tOCPHA;
    }

    public DietMeasurement getvITK1() {
        if (vITK1==null){
            vITK1=getDummy();
        }
        return vITK1;
    }

    public DietMeasurement getDummy(){
        DietMeasurement dietMeasurement=new DietMeasurement();
        return dietMeasurement;
    }

}
