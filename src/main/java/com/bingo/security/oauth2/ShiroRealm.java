package com.bingo.security.oauth2;

import com.bingo.common.util.ConvertUtils;
import com.bingo.modules.system.entity.SysUserEntity;
import com.bingo.security.entity.SysUserTokenEntity;
import com.bingo.security.service.ShiroService;
import com.bingo.security.user.UserPrincipal;
import jakarta.annotation.Resource;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 认证
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    @Lazy
    @Resource
    private ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof ShiroToken;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserPrincipal user = (UserPrincipal) principals.getPrimaryPrincipal();

        //用户权限列表
        Set<String> permsSet = shiroService.getUserPermissions(user);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户信息
        SysUserTokenEntity tokenEntity = shiroService.getByToken(accessToken);
        //token失效
        if (tokenEntity == null || tokenEntity.getExpireDate().getTime() < System.currentTimeMillis()) {
            throw new IncorrectCredentialsException("token不合法");
        }

        //查询用户信息
        SysUserEntity userEntity = shiroService.getUser(tokenEntity.getUserId());

        //转换成UserPrincipal
        UserPrincipal userPrincipal = ConvertUtils.sourceToTarget(userEntity, UserPrincipal.class);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userPrincipal, accessToken, getName());
        return info;
    }

}