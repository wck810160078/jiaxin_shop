package com.jiaxin.shop.security;


import com.jiaxin.shop.pojo.SysRequestPath;
import com.jiaxin.shop.pojo.SysRole;
import com.jiaxin.shop.service.SysRequestPathService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author hejiazhou
 * 加载请求需要的角色
 */
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Resource
    private SysRequestPathService sysRequestPathService;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {


            //获取请求地址
            String requestUrl = ((FilterInvocation) o).getRequestUrl();


            // 不需要权限控制的url
            if ("".equals(requestUrl)){
                    return null;

            }



        List<SysRequestPath> allPath = sysRequestPathService.getAllPath();
        List<SysRole> sysRoles = new ArrayList<>();
        for (SysRequestPath sysRequestPath : allPath) {
            if (antPathMatcher.match(sysRequestPath.getUrl(), requestUrl)&&sysRequestPath.getSysRoleList().size()>0) {
                    sysRoles.addAll(sysRequestPath.getSysRoleList());
                }
            }

            if(sysRoles.size()>0){
                int size = sysRoles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = sysRoles.get(i).getRoleName();
                }
                return SecurityConfig.createList(values);
            }

            return null;
        }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}