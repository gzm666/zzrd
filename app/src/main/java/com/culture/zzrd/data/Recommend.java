package com.culture.zzrd.data;

/**
 * Created by guozm on 2018/10/22.
 */

public class Recommend {
    private String url;
    private int id;
    private String title;

    public Recommend(int id, String url, String title) {
        setId(id);
        setTitle(title);
        setUrl(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
