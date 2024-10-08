package com.bingo.security.oauth2;

import com.bingo.common.util.MyException;
import java.security.MessageDigest;
import java.util.UUID;

/**
 * 生成token
 */
public class TokenGenerator {

    private static final char[] HEX_CODE = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(HEX_CODE[(b >> 4) & 0xF]);
            r.append(HEX_CODE[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generate() {
        try {
            String uuid = UUID.randomUUID().toString();

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(uuid.getBytes());
            byte[] tokenDigest = messageDigest.digest();
            return toHexString(tokenDigest);
        } catch (Exception e) {
            throw new MyException("token不合法", e);
        }
    }
}
