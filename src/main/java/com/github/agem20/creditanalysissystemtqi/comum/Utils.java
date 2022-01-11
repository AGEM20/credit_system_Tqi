package com.github.agem20.creditanalysissystemtqi.comum;

public class Utils {


    public static String somenteNumeros(String v) {
        if(v != null)
            return v.replaceAll("[^0-9]", "");
        return v;
    }

    public static String somenteLetrasAZ(String v) {
        if(v != null)
            return v.replaceAll("[^A-Za-z]", "");
        return v;
    }

    public static boolean isNullOrBlank(String s) {
        return (s == null || s.trim().equals(""));
    }

    public static boolean isNullOrEmpty(String s) {
        return (s == null || s.isEmpty());
    }
}
