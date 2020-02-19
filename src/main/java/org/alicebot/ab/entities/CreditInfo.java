package org.alicebot.ab.entities;


public class CreditInfo {
    private  String name;
    private  String address;
    private  String job;
    private  String phoneNumber;




    public CreditInfo() {
    }

    public  void  config(String code, String text) {

        switch (code) {
            case "CRN":
                name = text;
                break;
            case "CRJ":
                job = text;
                break;
            case "CRP":
                phoneNumber = text;
                break;
            case "CRD":
                address = text;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "សូមអរគុណយើងនឹងទំនងទំនងឆាប់ៗនេះ" +
                "ឈ្មោះ='" + name + '\'' +
                ", អាស័យដ្ឌាន='" + address + '\'' +
                ", មុខរបរ='" + job + '\'' +
                ", លេខទូរសព័្ទ='" + phoneNumber + '\'' ;
    }
}
