package com.bingo.security.password;

/**
 * 密码工具类
 */
public class PasswordUtils {
    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 加密
     */
    public static String encode(String str){
        return passwordEncoder.encode(str);
    }


    /**
     * 比较密码是否相等
     */
    public static boolean matches(String str, String password){
        return passwordEncoder.matches(str, password);
    }


}
