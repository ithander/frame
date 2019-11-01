package org.ithang.tools.model.auth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.ithang.system.role.bean.Role;
import org.ithang.system.user.bean.User;
import org.ithang.system.user.service.UserService;
import org.ithang.system.userResource.bean.UserResource;
import org.ithang.system.userResource.service.UserResourceService;
import org.ithang.system.userRole.bean.UserRole;
import org.ithang.system.userRole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private UserResourceService userResourceService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//通过用户名从数据库获取角色权限集
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		
		User user = (User) getAvailablePrincipal(principalCollection);
        if(null!=user){
        	List<UserRole> userRoles=userRoleService.listByUser(user.getId());
            if(null!=userRoles&&!userRoles.isEmpty()){
            	Set<String> roles = new HashSet<>();
            	for(UserRole uRole:userRoles){
            		roles.add(uRole.getRole_id());	
            	}
            	info.setRoles(roles);;
            }
            
            List<UserResource> userResources=userResourceService.listByUser(user.getId());
            if(null!=userResources&&!userResources.isEmpty()){
            	Set<String> resources = new HashSet<>();
            	for(UserResource uResource:userResources){
            		resources.add(uResource.getResource_id());
            	}
            	info.setStringPermissions(resources);
            }
        }
        
        return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (null==authenticationToken.getPrincipal()) {
            return null;
        }
        
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        
        //获取用户信息
        String name = token.getUsername();
        User user = userService.getByName(name);
        if(null==user){
        	throw new AccountException("用户名不正确");
        }
        String password = user.getUpass();
        if (null == password) {
            throw new AccountException("用户名不正确");
        } else if (!password.equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        
        //这里验证authenticationToken和simpleAuthenticationInfo的信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getUpass(), user.getUname());
        return simpleAuthenticationInfo;
	}

	
	
}
