package org.alicebot.ab.entities;

public class AdvertiseProduct {
    private  String code;
    private  String text;
    private String imgURL;
    private String buttonOptionList;


    public AdvertiseProduct() {
    }

    public AdvertiseProduct(String code, String text, String imgURL, String buttonOptionList) {
        this.code = code;
        this.text = text;
        this.imgURL = imgURL;
        this.buttonOptionList = buttonOptionList;
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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getButtonOptionList() {
        return buttonOptionList;
    }

    public void setButtonOptionList(String buttonOptionList) {
        this.buttonOptionList = buttonOptionList;
    }
}
