package com.example.smartcity_0715.pojo;

public class PressCate {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PressCate(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
