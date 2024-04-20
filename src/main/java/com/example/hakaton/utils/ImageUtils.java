package com.example.hakaton.utils;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Base64;

public class ImageUtils {

    public static String getBase64Image(byte[] image) throws IOException {
        if(image == null) {
            return null;
        }
        String imageType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(image));
        String base64Image = Base64.getEncoder().encodeToString(image);
        return "data:" + imageType + ";base64," + base64Image;
    }

}