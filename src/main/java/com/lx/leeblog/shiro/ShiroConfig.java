package com.lx.leeblog.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * create by @author lixing on 2020/1/29 19:09
 * shiro 配置类
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            @Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         *  过滤
         */
        Map<String, String> filtermap = new LinkedHashMap<String, String>();
        filtermap.put("/css/**", "anon");
        filtermap.put("/js/**", "anon");
        filtermap.put("/img/**", "anon");
        filtermap.put("/user/loginIndex", "anon");
        filtermap.put("/user/registerAdd", "anon");
        filtermap.put("/user/register", "anon");
        filtermap.put("/user/login", "anon");
        filtermap.put("/index", "anon");
        filtermap.put("/callback", "anon");
        filtermap.put("/logout", "logout");
        filtermap.put("/user/test", "perms[user:add]");
        filtermap.put("/admin/*", "perms[admin:all]");
        filtermap.put("/**", "authc");/* !!!大坑，这个一定要写到最后， 不然授权效果就没了 */
        shiroFilterFactoryBean.setLoginUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtermap);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(
            @Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager =
                new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
