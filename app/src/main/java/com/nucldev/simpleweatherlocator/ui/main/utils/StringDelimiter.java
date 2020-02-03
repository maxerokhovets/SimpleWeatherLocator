package com.nucldev.simpleweatherlocator.ui.main.utils;


public class StringDelimiter {
    private String string;

    public StringDelimiter(String string) {
        this.string = string;
    }

    public String divide(){
        String[] arr = this.string.split(" ");
        String dString = "";
        if(arr.length>2){
            dString = arr[0]+" "+arr[1]+"\n";
            for (int i=2; i<arr.length; i++){
                dString += arr[i]+" ";
            }
        } else
            dString = this.string;

        return dString;
    }
}
