package com.navinautomationlab.driver;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class ReadCongiFile {
    private Properties properties;



    public ReadCongiFile(String propertyFilePath){
        propertyFilePath = "src/test/resources/" + propertyFilePath;
        BufferedReader reader;     // This is predifined class used to read the file
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(".properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationURL(){
        String url= properties.getProperty("baseURL");
        return url;
    }
    public String getApplicationBrowser() {
        String myBrowser = properties.getProperty("browser");
        return myBrowser;
    }
    public String  getPassword(){
        String myPassword = properties.getProperty("password");
        byte[] encodedBytes = Base64.encodeBase64(myPassword.getBytes());
        System.out.println("encodedBytes "+ new String(encodedBytes));
        byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
        System.out.println("decodedBytes "+ new String(decodedBytes));
      return (new String(encodedBytes));
    }

    public String  getConfirmPassword(){
        String myConfirmPassword = properties.getProperty("confirmPassword");
        byte[] encodedBytes = Base64.encodeBase64(myConfirmPassword.getBytes());
        System.out.println("encodedBytes "+ new String(encodedBytes));
        byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
        System.out.println("decodedBytes "+ new String(decodedBytes));
        return (new String(encodedBytes));
    }

}
