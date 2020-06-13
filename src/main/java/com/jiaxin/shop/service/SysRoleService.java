package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.SysRoleMapper;
import com.jiaxin.shop.pojo.SysRole;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysRoleService {
    
    @Resource
    private SysRoleMapper sysRoleMapper ;
    
    /**
     * @Author chenting
     * @Description  新增/修改角色信息 
     * @Date 20:15 2020/6/11
     * @Param [sysRole]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg saveRole(SysRole sysRole) {
        if(BaseUtil.isBlank(sysRole.getId())) {
            return sysRoleMapper.insertSelective(sysRole) == 0 ? Msg.fail("新增角色信息失败") : Msg.success("新增角色信息成功");  
        }
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole) == 0 ? Msg.fail("修改角色信息失败") : Msg.success("修改角色信息成功");
    }
}
