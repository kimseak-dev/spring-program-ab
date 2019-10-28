package org.alicebot.ab.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message {

    private  String text;
    private  String contextCode;
    private  String status;
    private List<Product> productionList;
    private  List<UserOption> userOptionList;
    private  List<AdvertiseProduct> advertiseList;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

    public Message() {
        text = "";
        contextCode = "";
        status = "";
        productionList = new ArrayList<Product>();
        userOptionList = new ArrayList<UserOption>();
        advertiseList = new ArrayList<AdvertiseProduct>();
        date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContextCode() {
        return contextCode;
    }

    public void setContextCode(String contextCode) {
        this.contextCode = contextCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProductionList() {
        return productionList;
    }

    public void setProductionList(List<Product> productionList) {
        this.productionList = productionList;
    }

    public List<UserOption> getUserOptionList() {
        return userOptionList;
    }

    public void setUserOptionList(List<UserOption> userOptionList) {
        this.userOptionList = userOptionList;
    }

    public List getAdvertiseList() {
        return advertiseList;
    }

    public void setAdvertiseList(List<AdvertiseProduct> advertiseList) {
        this.advertiseList = advertiseList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void anylseData(String data){
        StringTokenAnalyser stringTokenAnalyser = new StringTokenAnalyser(data);
        text = stringTokenAnalyser.getText();
        contextCode = stringTokenAnalyser.getContext();
        status = "success";
        productionList = stringTokenAnalyser.getProductList();
        userOptionList = stringTokenAnalyser.getUserOptionList();
        advertiseList = stringTokenAnalyser.getAdvertiseList();
        date = new Date();



    }
}
