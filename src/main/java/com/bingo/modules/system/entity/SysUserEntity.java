package com.bingo.modules.system.entity;

import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserEntity extends BaseEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 头像
     */
    private String headUrl;
    /**
     * 性别   0：男   1：女    2：保密
     */
    private Integer gender;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 超级管理员   0：否   1：是
     */
    private Integer superAdmin;
    /**
     * 状态  0：停用   1：正常
     */
    private Integer status;
    /**
     * 部门名称
     */
    private String deptName;

}