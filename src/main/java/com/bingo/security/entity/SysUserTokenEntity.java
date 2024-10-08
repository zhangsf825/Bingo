package com.bingo.security.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户Token
 */
@Data
public class SysUserTokenEntity implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户token
     */
    private String token;
    /**
     * 过期时间
     */
    private Date expireDate;
    /**
     * 创建时间
     */
    private Date createDate;

}