package com.clouway;

public class StringSumator {

    public StringSumator() {
    }

    /**
     * Sums two string numbers if they are parsable to double
     * @param a first number to sum
     * @param b second number to sum
     * @return a+b
     */
    public String sum(String a, String b) {
        try {
            return String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
        } catch (NullPointerException e){
            throw new IllegalArgumentException();
        }

    }

}
