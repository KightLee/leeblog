package com.lx.leeblog.shiro;

import com.lx.leeblog.pojo.Permission;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.UserCheck;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * create by @author lixing on 2020/1/29 19:12
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserCheck userCheck;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权逻辑测试");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        /**
         * 在这里要重新去数据库查出带permission的user对象，不然报空！
         */
        User checkPermission = userCheck.checkPermission(user.getUsername());
        List<Permission> permissions = checkPermission.getPermissions();
        /**
         * 将持有的权限 迭代地注入到shiro的授权里面
         * lamda 写法
         */
        Set<String> setColl = permissions.stream().map(e ->
                e.getMenuname()
        ).collect(Collectors.toSet());
        info.addStringPermissions(setColl);
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证逻辑测试");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = new User();
        user.setUsername(token.getUsername());
        User usercheck = userCheck.checkNormalUser(user);
        if (usercheck == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(usercheck,
                usercheck.getPassword(), getName());
    }
}
