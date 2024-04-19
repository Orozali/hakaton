package com.example.hakaton.utils;


import java.util.Base64;

public class ImageUtils {

    public static String getBase64Image(byte[] image, String imageType){
        String base64Image = Base64.getEncoder().encodeToString(image);
        return "data:" + imageType + ";base64," + base64Image;
    }

}