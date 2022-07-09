package com.example.qu.utils;

import lombok.Value;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class AESUtil {
    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }


    public static SecretKey convertKeyToSecretKey() {
        String quAESSecretKey = "1234567890123456";
        SecretKey secretKey =  new SecretKeySpec(quAESSecretKey.getBytes(), "AES");
        return secretKey;
    }

//    public static  SecretKey stringToSecretKey(String encodedKey, String algorithm){
//        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
//        //rebuild using SecretKeySpec
//        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, algorithm);
//        return originalKey;
//
//    }
//    public static secretKeyToString(SecretKey key){
//
//    }
}
