package com.jiaxin.shop.security;


import com.jiaxin.shop.dao.SysUserMapper;
import com.jiaxin.shop.pojo.JxUser;
import com.jiaxin.shop.pojo.SysRole;
import com.jiaxin.shop.pojo.SysUser;
import com.jiaxin.shop.pojo.common.PublicConstants;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
                    sysUser.getPhoneNumber(),
                    sysUser.getPassword(),
                    sysUser.getEnabled(),
                    sysUser.getSysRoleList()
            );
        }

        return null;
    }

}
