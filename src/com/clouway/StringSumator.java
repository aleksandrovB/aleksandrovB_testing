package com.clouway;

public class StringSumator {

    public StringSumator() {
    }

//    public String sumWithTest(String a, String b) throws IllegalArgumentException{
//        if(a==null || b==null){
//            throw new IllegalArgumentException("A and B cannot be null");
//        }
//        return String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
//    }

    public String sum(String a, String b) {
        try {
            return String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
        } catch (NullPointerException e){
            throw new IllegalArgumentException();
        }

    }

}
