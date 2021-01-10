package com.example.baucua;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    public static String formatMoney(float i){
        NumberFormat numberFormat = new DecimalFormat("#,###");
        return numberFormat.format(i);
    }
    public static float getMoney(String i){
        return Float.parseFloat(i.replace(",",""));
    }
    public static int getMoneyI(String i){
        return Integer.parseInt(i.replace(",",""));
    }
}