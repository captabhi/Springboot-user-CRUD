package com.example.UserApp.UserApp.Utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALFABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateUserID(int length)
    {
        return generateRandomString(length);
    }

    public String generateAddressID(int length)
    {
        return generateRandomString(length);
    }

    public String generateRandomString(int length)
    {
        StringBuilder str = new StringBuilder(length);

        for(int i =0; i<length;i++)
        {
            str.append(ALFABET.charAt(RANDOM.nextInt(ALFABET.length())));
        }
        return new String(str);
    }
}
