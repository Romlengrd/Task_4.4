package com.company;

import java.io.Serializable;
import java.util.Arrays;

public class Film implements Serializable {

    private String name;
    private String[] actor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getActor() {
        return actor;
    }

    public void setActor(String[] actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", actor=" + Arrays.toString(actor) +
                '}';
    }
}
