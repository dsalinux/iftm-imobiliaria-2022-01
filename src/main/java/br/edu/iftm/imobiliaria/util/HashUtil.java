package br.edu.iftm.imobiliaria.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author danilo
 */
public class HashUtil {

    public static String hex(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i]
                    & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    public static String md5Hex(String message) {
        try {
            MessageDigest md
                    = MessageDigest.getInstance("MD5");
            return hex(md.digest(message.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }
    
    public static String sha256Hex(String message) {
        try {
            MessageDigest md
                    = MessageDigest.getInstance("SHA-256");
            return hex(md.digest(message.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }
}
