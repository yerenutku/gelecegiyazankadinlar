package com.erenutku.bottomnavigationexample301.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yutku on 18/06/17.
 */
public class GamesModel {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("teamsize")
    private String teamsize;
    @SerializedName("type")
    private String type;
    @SerializedName("typeicon")
    private String typeicon;
    @SerializedName("cardimage")
    private String cardimage;
    @SerializedName("shortexplanation")
    private String shortexplanation;
    @SerializedName("fragmentdetail")
    private List<String> fragmentdetail = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeamsize() {
        return teamsize;
    }

    public void setTeamsize(String teamsize) {
        this.teamsize = teamsize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeicon() {
        return typeicon;
    }

    public void setTypeicon(String typeicon) {
        this.typeicon = typeicon;
    }

    public String getCardimage() {
        return cardimage;
    }

    public void setCardimage(String cardimage) {
        this.cardimage = cardimage;
    }

    public String getShortexplanation() {
        return shortexplanation;
    }

    public void setShortexplanation(String shortexplanation) {
        this.shortexplanation = shortexplanation;
    }

    public List<String> getFragmentdetail() {
        return fragmentdetail;
    }

    public void setFragmentdetail(List<String> fragmentdetail) {
        this.fragmentdetail = fragmentdetail;
    }
}
