package com.erenutku.bottomnavigationexample301.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yutku on 18/06/17.
 */

public class MyJsonModel {
    @SerializedName("cinsiyet")
    private boolean cinsiyet;

    @SerializedName("yasi")
    private int age;

    private String ismi;

    public boolean isCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(boolean cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIsmi() {
        return ismi;
    }

    public void setIsmi(String ismi) {
        this.ismi = ismi;
    }
}
