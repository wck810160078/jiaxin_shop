package com.jiaxin.shop.service;

import com.jiaxin.shop.pojo.*;
import com.jiaxin.shop.utils.Msg;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SysUserService {


    SysUser selectByName(String username);

    int update(SysUser sysUser);

    Msg registerUser(SysUser sysUser);

    SysUser getUser(HttpServletRequest request);

    /**
     * 通过用户名获取
     * @param username
     * @return
     */
    Map<String, Boolean> getUserByAccount(String username, boolean need);


    /**
     * @Author chenting
     * @Description  新增员工
     * @Date 23:32 2020/6/6
     * @Param [sysUser]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg saveStaff(SysUser sysUser, HttpServletRequest request) throws Exception;

}
