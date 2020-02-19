package org.alicebot.ab.entities;

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


    // @desc: string token tag
    // @param: tag
    // @auth: seak
    public String getTagTokenString(String data, String tag) {
        Pattern pattern = Pattern.compile("<"+ tag +">(.*?)</" + tag +">", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            return  matcher.group(1);
        }
        return "";
    }

    // @desc: product list
    // @tag: products, product
    // @auth: seak
    public List<Product> getProductList() {
        List<Product>  list= new ArrayList<Product>();
        String productTokenString = getTagTokenString(tokenString, "products");
        Pattern pattern = Pattern.compile("<product>(.*?)</product>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(tokenString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            String data = matcher.group(1);
            Product product = new Product();
            product.setCode(getTagTokenString(data, "code"));
            product.setImg(getTagTokenString(data, "img"));
            product.setText(getTagTokenString(data, "txt"));
            product.setButton(getTagTokenString(data, "button"));
            list.add(product);
        }
       return list;
    }

    // @desc: user option list
    // @tag: usropts, usropt
    // @auth: seak
    public List<UserOption> getUserOptionList(){
        List<UserOption> list = new ArrayList<UserOption>();
        String userOptionTokenString = getTagTokenString(tokenString, "usropts");
        Pattern pattern = Pattern.compile("<usropt>(.*?)</usropt>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(tokenString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            String data = matcher.group(1);
            UserOption userOption = new UserOption();
            userOption.setCode(getTagTokenString(data, "code"));
            userOption.setText(getTagTokenString(data, "txt"));
            list.add(userOption);
        }
        return list;
    }

    // @desc: advertise product list
    // @tag:  advertisements, advertisement
    // @auth: seak
    public List<AdvertiseProduct> getAdvertiseList(){
        List<AdvertiseProduct> list = new ArrayList<AdvertiseProduct>();
        String userOptionTokenString = getTagTokenString(tokenString, "advertisements");
        Pattern pattern = Pattern.compile("<advertisement>(.*?)</advertisement>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(tokenString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            String data = matcher.group(1);
            AdvertiseProduct advertiseProduct = new AdvertiseProduct();



            list.add(advertiseProduct);
        }
        return list;
    }

    // @desc: context
    // @tag: context
    // @auth: seak
    public  String getContext(){
        return getTagTokenString(tokenString, "context");
    }

    // @desc: text
    // @tag: text
    // @auth: seak
    public  String getText(){
        return getTagTokenString(tokenString, "text");
    }

}
