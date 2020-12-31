package com.example.class25;

public class NewsInfo {
    private String icon;
    private String title;
    private String content;
    private int type;
    private int comment;

    public NewsInfo(String icon,String title,String content,int type,int comment){
        this.icon=icon;
        this.title=title;
        this.content=content;
        this.type=type;
        this.comment=comment;

    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}

