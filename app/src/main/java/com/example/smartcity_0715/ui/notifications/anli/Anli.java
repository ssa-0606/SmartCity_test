package com.example.smartcity_0715.ui.notifications.anli;

public class Anli {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Anli(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
