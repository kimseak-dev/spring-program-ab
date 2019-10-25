package org.alicebot.ab.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AITextUtil {

    private  String text;
    private List list;
    private  String code;
    private  String orignText;

    public String getOrignText() {
        return orignText;
    }

    public void setOrignText(String orignText) {
        this.orignText = orignText;
    }

    public AITextUtil() {
        text = " ";
        List list = new ArrayList();
        code = " ";
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public  void analyseAIStringToken(String ai) {
        orignText = ai;
        System.out.println(ai);
        code = getAITokenCode(ai);
        list = getAIDataList(ai);
        text = getTextToken(ai);
    }


    public String getAITokenCode(String ai){
        Pattern pattern = Pattern.compile("<code>(.*?)</code>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(ai);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            return matcher.group(1);
        }
        return "";
    }

    public List<String> getAIDataList(String ai) {
        List list = new ArrayList<String>();
        Pattern pattern = Pattern.compile("<li>(.*?)</li>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(ai);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            list.add(matcher.group(1));
        }

        return  list;

    }

    public String getTextToken(String ai){
        Pattern pattern = Pattern.compile("<text>(.*?)</text>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(ai);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            return matcher.group(1);
        }

        return "";
    }


}
