package com.springboot.project.URLShortner.service;


import com.springboot.project.URLShortner.Encode.Base62Encode;
import com.springboot.project.URLShortner.models.UrlPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class KeyGeneratorService{

    private String key;

    //@Autowired
    //UrlPojo urlPojo;

   /* public KeyGeneratorService(UrlPojo urlPojo)
    {
        this.urlPojo = urlPojo;
    }*/

    public String generateKeyByHash(String longurl) throws NoSuchAlgorithmException {
      // System.out.println("get Long URL inside its Hashing function"+longurl);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(
                longurl.getBytes(StandardCharsets.UTF_8));
        return convertByteToHex(encodedHash);

    }

    public String generateRandomString() throws NoSuchAlgorithmException {
        //generate Random key
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecureRandom secRandom = new SecureRandom();
        keyGen.init(secRandom);
        Key key = keyGen.generateKey();
        //System.out.println("KEY FORMAT: "+key.getEncoded());
        //return keyGen.generateKey().getFormat();
        //return key.getEncoded();
        return convertByteToHex(key.getEncoded());
    }

    public String convertByteToHex(byte encodedHash[]){
        StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            //System.out.println("hexString"+encodedhash.toString());
        for (int i = 0; i < encodedHash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedHash[i]);
                //System.out.println(hex);
            if(hex.length() == 1) {
                hexString.append('0');
            }hexString.append(hex);
            }
            //System.out.println(hexString.toString());
            return hexString.toString();
        }

        String createKey(String longURL) throws NoSuchAlgorithmException{
            String finalString = generateKeyByHash(longURL) + generateRandomString();
            System.out.println("String to be encoded: " + finalString);
            int intValue = Base62Encode.base62(finalString);
            System.out.println("Int Value " + intValue);
            String key = Base62Encode.base62(intValue);
            System.out.println("String Key value: "+key);
            return key;
        }




}

