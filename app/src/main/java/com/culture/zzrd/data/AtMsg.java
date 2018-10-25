package com.culture.zzrd.data;

/**
 * Created by guozm on 2018/10/24.
 */

public class AtMsg {
    private int id;
    private String headUrl;
    private String time;
    private String message;
    private String name;
    private String atContent;
    private int atId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAtContent() {
        return atContent;
    }

    public void setAtContent(String atContent) {
        this.atContent = atContent;
    }

    public int getAtId() {
        return atId;
    }

    public void setAtId(int atId) {
        this.atId = atId;
    }
}
