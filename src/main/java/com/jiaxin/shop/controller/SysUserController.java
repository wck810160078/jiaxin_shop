package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.SysUser;
import com.jiaxin.shop.service.SysUserService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SysUserController {

    @Resource
    private SysUserService sysUserService ;
    @Resource
    private HttpServletResponse response ;
    @Resource
    private HttpServletRequest request ;

    /**
     * @Author chenting
     * @Description  新增员工 
     * @Date 23:32 2020/6/6
     * @Param [sysUser]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping( value ="/admin/saveStaff" ,produces = { "application/json;charset=UTF-8" })
    public Msg saveStaff(@RequestBody SysUser sysUser,HttpServletRequest request ) throws Exception {
        if(BaseUtil.isBlank(sysUser.getUsername())&& (sysUser.getSysRoleList() == null || sysUser.getSysRoleList().size() == 0)) {
            return Msg.fail("新增失败，用户名与角色不能为空") ;
        }
        return sysUserService.saveStaff(sysUser,request) ;
    }
}
