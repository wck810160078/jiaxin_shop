package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.SysRole;
import com.jiaxin.shop.service.SysRoleService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class sysRoleController {

    @Resource
    private SysRoleService sysRoleService ;

    /**
     * @Author chenting
     * @Description  新增/修改角色信息
     * @Date 19:59 2020/6/11
     * @Param [sysRole]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/admin/saveRole")
    public Msg saveRole(@RequestBody SysRole sysRole) {
        if(BaseUtil.isBlank(sysRole.getRoleName(),sysRole.getRoleDescription())) {
            return Msg.fail("缺少关键参数-角色名称/角色描述") ;
        }
        return sysRoleService.saveRole(sysRole) ;
    }
}
