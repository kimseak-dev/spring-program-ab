package org.alicebot.ab.entities;

public class ClientMessage {

   private String text;
   private String  textCode;
   private String service;
   private String context;

    public ClientMessage() {
    }

    public ClientMessage(String text, String textCode, String service, String context) {
        this.text = text;
        this.textCode = textCode;
        this.service = service;
        this.context = context;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextCode() {
        return textCode;
    }

    public void setTextCode(String textCode) {
        this.textCode = textCode;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
