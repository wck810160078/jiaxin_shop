package com.jiaxin.shop.security;


import com.jiaxin.shop.dao.SysUserMapper;
import com.jiaxin.shop.pojo.JxUser;
import com.jiaxin.shop.pojo.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hejiazhou
 * 授权登录认证
 *
 */

@Service
public class UserLoginServiceImpl implements UserDetailsService {
    @Resource
    private SysUserMapper userMapper;



    /**
     * 登录验证
     * @param username 账号/手机号码
     * @return 账号权限信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) {

        SysUser sysUser = userMapper.selectByName(username);

        if(sysUser!=null){
            return new JxUser(
                    sysUser.getUsername(),
                    sysUser.getPassword(),
                    sysUser.getEnabled(),
                    sysUser.getSysRoleList()
            );
        }

        return null;
    }

}
