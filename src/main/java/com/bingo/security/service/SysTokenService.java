package com.bingo.security.service;

import com.bingo.common.util.ResultBean;

/**
 * 用户Token
 */
public interface SysTokenService {

    /**
     * 生成token
     */
    ResultBean createToken(Long userId);

    /**
     * 退出，修改token值
     */
    void logout(Long userId);

}