package com.bingo.security.service.impl;

import com.bingo.modules.system.entity.SysUserEntity;
import com.bingo.modules.system.mapper.SysMenuMapper;
import com.bingo.security.entity.SysUserTokenEntity;
import com.bingo.security.service.ShiroService;
import com.bingo.security.user.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ShiroServiceImpl implements ShiroService {
    private final SysMenuMapper sysMenuMapper;

    @Override
    public Set<String> getUserPermissions(UserPrincipal user) {
        //用户权限列表
        Set<String> permsSet = new HashSet<>();

        return permsSet;
    }

    @Override
    public SysUserTokenEntity getByToken(String token) {
        return null;
    }

    @Override
    public SysUserEntity getUser(Long userId) {
        return null;
    }


}