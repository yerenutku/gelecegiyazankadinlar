package com.erenutku.easynotes.model;

/**
 * Created by yutku on 08/07/17.
 */

public class NoteModel {
    private String title;
    private String body;
    private boolean favorite;
    private String key;

    public NoteModel() {
    }

    public NoteModel(String title, String body, boolean favorite, String key) {
        this.title = title;
        this.body = body;
        this.favorite = favorite;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        favorite = favorite;
    }
}
