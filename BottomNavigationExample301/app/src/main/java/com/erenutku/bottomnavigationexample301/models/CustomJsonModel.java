package com.erenutku.bottomnavigationexample301.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by yutku on 18/06/17.
 */

public class CustomJsonModel {
    @SerializedName("game_version")
    private String mGameVersion;
    @SerializedName("json_version")
    private String mJsonVersion;

    @SerializedName("games")
    private ArrayList<GamesModel> games;

    public String getGameVersion() {
        return mGameVersion;
    }

    public void setGameVersion(String gameVersion) {
        mGameVersion = gameVersion;
    }

    public String getJsonVersion() {
        return mJsonVersion;
    }

    public void setJsonVersion(String jsonVersion) {
        mJsonVersion = jsonVersion;
    }

    public ArrayList<GamesModel> getGames() {
        return games;
    }

    public void setGames(ArrayList<GamesModel> games) {
        this.games = games;
    }
}
