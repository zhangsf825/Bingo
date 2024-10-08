package com.bingo.security.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 验证码
 */
public interface CaptchaService {

    /**
     * 图片验证码
     */
    void create(HttpServletResponse response, String uuid) throws IOException;

    /**
     * 验证码效验
     */
    boolean validate(String uuid, String code);
}