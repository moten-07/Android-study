package com.example.class12;

public class Meg {
    public static final boolean TYPE_RECEIVE=false;//接受信息类型
    public static final boolean TYPE_SEND=true;//发送信息的类型
    public boolean type;//信息类型
    public String content;//信息内容

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Meg(boolean type, String content){
        this.type=type;
        this.content=content;
    }
}
