package com.erenutku.bottomnavigationexample301.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by yutku on 18/06/17.
 */

public class OgrencilerResponse {
    @SerializedName("sinif")
    private String sinif;
    @SerializedName("sehir")
    private String sehir;
    @SerializedName("ogrenciler")
    private ArrayList<Ogrenci> ogrenciler;

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public ArrayList<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }

    public void setOgrenciler(ArrayList<Ogrenci> ogrenciler) {
        this.ogrenciler = ogrenciler;
    }
}
