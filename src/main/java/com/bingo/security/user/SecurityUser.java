package com.bingo.security.user;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 用户
 */
public class SecurityUser {

    public static Subject getSubject() {
        try {
            return SecurityUtils.getSubject();
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 获取用户信息
     */
    public static UserPrincipal getUser() {
        Subject subject = getSubject();
        if(subject == null){
            return new UserPrincipal();
        }

        UserPrincipal user = (UserPrincipal)subject.getPrincipal();
        if(user == null){
            return new UserPrincipal();
        }

        return user;
    }

    /**
     * 获取用户ID
     */
    public static Long getUserId() {
        return getUser().getId();
    }

    /**
     * 获取部门ID
     */
    public static Long getDeptId() {
        return getUser().getDeptId();
    }
}