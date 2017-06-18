package com.erenutku.bottomnavigationexample301.models;

/**
 * Created by yutku on 17/06/17.
 */

public class CustomModel {
    private String text;
    private int resourceId;
    public CustomModel (String text, int resourceId){
        this.text = text;
        this.resourceId = resourceId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
