package com.spartaglobal.day4;

import java.util.*;

public class Passport {
    private HashMap<String,String> credentials = new HashMap<>();
    private static final ArrayList<String> requiredCredentials = new ArrayList<>();
//    private String byr; //Birth Year
//    private String iyr; //Issue Year
//    private String eyr; //Expiration Year
//    private String hgt; //Height
//    private String hcl; //Hair Color
//    private String ecl; //Eye Color
//    private String pid; //Passport ID
//    private String cid; //Country ID
    static{
        requiredCredentials.addAll(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"));
}

    public void addInfo(String info){
        LinkedList<String> infoParts = new LinkedList<>(Arrays.asList(info.split("[: ]")));
        while(infoParts.size()>0){
            if(!credentials.containsKey(infoParts.peek()) && requiredCredentials.contains(infoParts.peek())){
                String credential = infoParts.poll();
                String value = infoParts.poll();
                credentials.put(credential,value);
            }else{
                infoParts.remove();
            }
        }
    }

    public boolean isValid(String... except){
        for (String requiredCredential : requiredCredentials) {
            if(!Arrays.asList(except).contains(requiredCredential)) {
                if (!credentials.containsKey(requiredCredential) || !isValidCredential(requiredCredential)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidCredential(String credential){
        switch (credential){
            case "byr": {
                boolean matchPatter = credentials.get(credential).matches("\\d{4}");
                if(matchPatter){
                    int value = Integer.parseInt(credentials.get(credential));
                    return value >= 1920 && value <= 2002;
                }
                return false;
            }
            case "iyr": {
                boolean matchPatter = credentials.get(credential).matches("\\d{4}");
                if(matchPatter){
                    int value = Integer.parseInt(credentials.get(credential));
                    return value >= 2010 && value <= 2020;
                }
                return false;
            }
            case "eyr":{
                boolean matchPatter = credentials.get(credential).matches("\\d{4}");
                if(matchPatter){
                    int value = Integer.parseInt(credentials.get(credential));
                    return value >= 2020 && value <= 2030;
                }
                return false;
            }
            case "hgt": {
                boolean matchPatter = credentials.get(credential).matches("\\d*(cm|in)");
                if(matchPatter){
                    String stringValue = credentials.get(credential);
                    int integerValue = Integer.parseInt(stringValue.replaceAll("[a-zA-z]*", ""));
                    stringValue = stringValue.replaceAll("\\d*", "");
                    switch (stringValue){
                        case "in": {
                            return integerValue >= 59 && integerValue <= 76;
                        }
                        case "cm": {
                            return integerValue >= 150 && integerValue <= 193;
                        }
                    }
                }
                return false;
            }
            case "hcl": {
                return credentials.get(credential).matches("#[\\d,a-f]{6}");
            }
            case "ecl": {
                return credentials.get(credential).matches("(amb|blu|brn|gry|grn|hzl|oth)");
            }
            case "pid": {
                return credentials.get(credential).matches("\\d{9}");
            }
            case "cid": {
                return credentials.get(credential).matches("");
            }
            default: return true;
        }
    }

    public HashMap<String, String> getCredentials() {
        return credentials;
    }

    public static ArrayList<String> getRequiredCredentials() {
        return requiredCredentials;
    }
}
