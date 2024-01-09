package com.nguyenduyanh.DAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptSHA {
    public String encryptSHA(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] inputBytes = input.getBytes();
            md.update(inputBytes);
            byte[] hashedBytes = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
           return   hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
