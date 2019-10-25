package org.alicebot.ab.model;

public class ClientMessage {
   private String  code;
   private String text;
   private String service;

    public ClientMessage(String code, String text, String service) {
        this.code = code;
        this.text = text;
        this.service = service;
    }

    public ClientMessage() {
        code = "";
        text = "";
        service = "";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
