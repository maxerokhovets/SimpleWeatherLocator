package com.nucldev.simpleweatherlocator.ui.main.utils;

public class FirstLetterToUpperCase {
    private String string;

    public FirstLetterToUpperCase(String string) {
        this.string = string;
    }
    public String toUpperCase(){
        char[] chArr = this.string.toCharArray();
        String s1 = String.valueOf(chArr[0]).toUpperCase();
        String str = s1+this.string.substring(1);
        return str;
    }
}
