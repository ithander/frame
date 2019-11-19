package org.ithang.tools.shiro;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.ithang.tools.model.auth.AuthRealm;
import org.ithang.tools.model.auth.CredentialsMatcher;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

	 @Bean(name="shiroFilter")
	 public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
	        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
	        
	        //自定义拦截器的配置
	        Map<String,Filter> filter=new HashMap<>();
	        filter.put("custom", new ShiroUserFilter());
	        bean.setFilters(filter);
	        
	        // 安全管理器
	        bean.setSecurityManager(manager);
	        
	        //配置登录的url和登录成功的url
	        bean.setLoginUrl("/login");
	        bean.setSuccessUrl("/home");
	        //配置访问权限
	        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
	        filterChainDefinitionMap.put("/", "anon");
	        filterChainDefinitionMap.put("/static/**","anon");
	        filterChainDefinitionMap.put("/bootstrap/**","anon");
	        filterChainDefinitionMap.put("/css/**","anon");
	        filterChainDefinitionMap.put("/easyui/**","anon");
	        filterChainDefinitionMap.put("/layui/**","anon");
	        filterChainDefinitionMap.put("/test/**","anon");
	        
	        filterChainDefinitionMap.put("/app", "anon");
	        filterChainDefinitionMap.put("/sindex", "anon");
	        
	        filterChainDefinitionMap.put("/sys", "anon");
	        
	        filterChainDefinitionMap.put("/login", "anon");
	        filterChainDefinitionMap.put("/logout", "anon");
	        
	        filterChainDefinitionMap.put("/slogin", "anon");
	        filterChainDefinitionMap.put("/slogout", "anon");
	        
	        filterChainDefinitionMap.put("/home", "authc");
	        filterChainDefinitionMap.put("/mail", "authc");
	        filterChainDefinitionMap.put("/app/**", "authc");
	        filterChainDefinitionMap.put("/sys/**", "authc");
	        /*filterChainDefinitionMap.put("/static/**","anon");
	        filterChainDefinitionMap.put("/auth/*","authc");//表示需要认证才可以访问
	        filterChainDefinitionMap.put("/auth/**","authc");//表示需要认证才可以访问
	        filterChainDefinitionMap.put("/auth/*.*","authc");*/
	        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
	        return bean;
	    }
	    //配置核心安全事务管理器
	    @Bean(name="securityManager")
	    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
	        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
	        manager.setRealm(authRealm);
	        manager.setSessionManager(sessionManager());
	        return manager;
	    }
	    //配置自定义的权限登录器
	    @Bean(name="authRealm")
	    
	    
	    public AuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
	        AuthRealm authRealm=new AuthRealm();
	        authRealm.setCredentialsMatcher(matcher);
	        return authRealm;
	    }
	    //配置自定义的密码比较器
	    @Bean(name="credentialsMatcher")
	    public CredentialsMatcher credentialsMatcher() {
	        return new CredentialsMatcher();
	    }
	    
	    @Bean
	    public SessionManager sessionManager() {
	    	SysSessionManager sessionManager = new SysSessionManager();
	        return sessionManager;
	    }
	    
	    @Bean
	    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
	        return new LifecycleBeanPostProcessor();
	    }
	    @Bean
	    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
	        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
	        creator.setProxyTargetClass(true);
	        return creator;
	    }
	    @Bean
	    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
	        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
	        advisor.setSecurityManager(manager);
	        return advisor;
	    }

}
