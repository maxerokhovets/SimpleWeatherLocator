package com.nucldev.simpleweatherlocator.ui.main.utils;

public class Rounding {

    //todo округление отрицательных чисел
    public static double floorRounding(double x, int n){
        double m = Math.pow(10, n);
        x= Math.floor(x*m)/m;
        return x;
    }

    public static double ceilRounding(double x, int n){
        double m = Math.pow(10, n);
        x = Math.ceil(x*m)/m;
        return x;
    }

    public static double mathRounding(double x, int n){
        int m = (int) ( Math.pow(10, n)*x);
        int m1 = (int)(Math.pow(10, n+1)*x);
        if(m1-m*10>=5)
            return Rounding.ceilRounding(x, n);
        else
            return Rounding.floorRounding(x, n);
    }

    public static double bankRounding(double x, int n) {
        int m = (int) (Math.pow(10, n)*x);
        int m1 = (int)(Math.pow(10, n+1)*x);
        if(m1-m*10==5)
            if(m%2==0)
                return Rounding.floorRounding(x, n);
            else
                return Rounding.ceilRounding(x, n);
        else
            return Rounding.mathRounding(x, n);
    }
}
