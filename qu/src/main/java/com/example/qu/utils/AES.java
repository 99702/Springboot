package com.example.qu.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/* https://www.baeldung.com/java-aes-encryption-decryption */

@Component
public class AES {
    public  String encryptText(String algorithm, String inputString, SecretKey key) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(inputString.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

//    @Bean
//    public  String  decryptText(String algorithm, String cipherText, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
//        Cipher cipher = Cipher.getInstance(algorithm);
//        cipher.init(Cipher.DECRYPT_MODE, (Key) key, iv);
//        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
//        return new String(plainText);
//    }
//
}
