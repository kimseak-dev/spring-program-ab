package org.alicebot.ab.entities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTokenAnalyser {


    private String tokenString;


    public StringTokenAnalyser(String tokenString) {
        this.tokenString = tokenString;
    }

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    public List<Product> getProductList() {

        List<Product>  list= new ArrayList<Product>();

        String productTokenString = getProductTag("products");



        Pattern pattern = Pattern.compile("<product>(.*?)</product>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(tokenString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            String data = matcher.group(1);

            Product product = new Product();
            product.setCode(getTag(data, "code"));
            product.setImgURL(getTag(data, "img"));
            product.setText(getTag(data, "txt"));
            list.add(product);
        }
       return list;
    }

    public String getProductTag(String tag){
        Pattern pattern = Pattern.compile("<"+ tag +">(.*?)</" + tag +">", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(tokenString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            return  matcher.group(1);
        }
        return  "";
    }

    public String getTag(String data, String tag) {
        Pattern pattern = Pattern.compile("<"+ tag +">(.*?)</" + tag +">", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            return  matcher.group(1);
        }
        return "";
    }

    public List<UserOption> getUserOptionList(){
        return new ArrayList<UserOption>();
    }

    public List<AdvertiseProduct> getAdvertiseList(){
        return new ArrayList<AdvertiseProduct>();
    }


    // @desc: get context code
    public String getContext() {
        Pattern pattern = Pattern.compile("<context>(.*?)</context>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(tokenString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            return matcher.group(1);
        }
        return "";
    }


    // @des: get Text
    public String getText(){
        Pattern pattern = Pattern.compile("<text>(.*?)</text>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(tokenString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            return matcher.group(1);
        }
        return "";
    }

    // @desc: get Type
    public String getMsgType(){
        Pattern pattern = Pattern.compile("<type>(.*?)</type>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(tokenString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            return matcher.group(1);
        }
        return "";
    }





}
