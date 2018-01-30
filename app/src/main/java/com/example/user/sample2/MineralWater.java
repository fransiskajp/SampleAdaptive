package com.example.user.sample2;

/**
 * Created by user on 29/01/2018.
 */

class MineralWater {
    private String name;
    private String info;
    private final int imageResource;


    MineralWater(String name, String info, int imageResource) {
        this.name = name;
        this.info = info;
        this.imageResource = imageResource;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getInfo() {
        return info;
    }

    void setInfo(String info) {
        this.info = info;
    }

    public int getImageResource() {
        return imageResource;
    }
}
