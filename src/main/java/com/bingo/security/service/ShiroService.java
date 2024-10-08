package com.bingo.security.service;


import com.bingo.modules.system.entity.SysUserEntity;
import com.bingo.security.entity.SysUserTokenEntity;
import com.bingo.security.user.UserPrincipal;

import java.util.Set;


public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(UserPrincipal user);

    SysUserTokenEntity getByToken(String token);

    /**
     * 根据用户ID，查询用户
     */
    SysUserEntity getUser(Long userId);

}
