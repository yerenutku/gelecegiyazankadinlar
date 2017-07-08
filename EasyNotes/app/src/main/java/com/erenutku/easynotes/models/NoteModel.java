package com.erenutku.easynotes.models;

/**
 * Created by yutku on 08/07/17.
 */

public class NoteModel {
    private String title;
    private String body;
    private boolean favorite;

    public NoteModel() {
    }

    public NoteModel(String title, String body, boolean favorite) {
        this.title = title;
        this.body = body;
        this.favorite = favorite;
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
