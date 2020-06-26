package com.jiaxin.shop.service;

import com.jiaxin.shop.pojo.SysRole;
import com.jiaxin.shop.utils.Msg;

public interface SysRoleService {
    

    /**
     * @Author chenting
     * @Description  新增/修改角色信息 
     * @Date 20:15 2020/6/11
     * @Param [sysRole]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg saveRole(SysRole sysRole);
}
