package com.springboot.project.URLShortner.Encode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

@Component
public class Base62Encode {

    static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    //Returns the base 62 value of a string
     public static int base62(String value) {
        int result = 0;
        int power = 1;
        for (int i = value.length() - 1; i >= 0; i--) {
            int digit = value.charAt(i) - 48;
            if (digit > 42) {
                digit -= 13;
            } else if (digit > 9) {
                digit -= 7;
            }
            result += digit * power;
            power *= 62;
        }
        return result;
    }

    //Returns base62 value of an Integer
    public static String base62(int value) {
        final StringBuilder sb = new StringBuilder(10);
        value  = Math.abs(value);
        do {
          sb.insert(0, BASE62[value % 62]);
          value /= 62;
        } while (value > 0);
        return sb.toString();
  }


}


