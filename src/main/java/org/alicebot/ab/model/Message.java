package org.alicebot.ab.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Message {

    private  String text;
    private  String type;
    private  String status;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

    public  Message(String msg){
        status = "success";
        date = new Date();
        text = msg;
        type = "text";

    }

    public Message() {
        
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
