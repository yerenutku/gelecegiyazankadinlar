package com.erenutku.bottomnavigationexample301.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yutku on 18/06/17.
 */

public class Ogrenci {
    @SerializedName("ogrenci")
    private String ogrenci;
    @SerializedName("yas")
    private String yas;

    public String getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(String ogrenci) {
        this.ogrenci = ogrenci;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }
}
