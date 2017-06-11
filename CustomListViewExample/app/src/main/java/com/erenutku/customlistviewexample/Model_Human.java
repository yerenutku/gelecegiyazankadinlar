package com.erenutku.customlistviewexample;

/**
 * Created by yutku on 11/06/17.
 */

public class Model_Human {
    private boolean action;
    private String name;

    public Model_Human(boolean action, String name){
        this.action = action;
        this.name = name;
    }

    public boolean getAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
