package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.SysPermissionMapper;
import com.jiaxin.shop.dao.SysUserMapper;
import com.jiaxin.shop.dao.SysUserPermissionRelationMapper;
import com.jiaxin.shop.dao.SysUserRoleRelationMapper;
import com.jiaxin.shop.pojo.*;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserRoleRelationMapper sysUserRoleRelationMapper;
    @Resource
    private SysUserPermissionRelationMapper sysUserPermissionRelationMapper ;

    public SysUser selectByName(String username) {
        return sysUserMapper.selectByName(username);
    }

    public int update(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    public Msg registerUser(SysUser sysUser) {
        if(sysUserMapper.insertSelective(sysUser)==0){
            return Msg.fail("注册失败");
        }
        SysUserRoleRelation sysUserRoleRelation = new SysUserRoleRelation();
        sysUserRoleRelation.setRoleId(2);
        sysUserRoleRelation.setUserId(sysUser.getId());
        return sysUserRoleRelationMapper.insertSelective(sysUserRoleRelation)==0? Msg.fail("注册失败"):Msg.success("注册成功");
    }

    public SysUser getUser(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        if(principal==null){
            return null;
        }
        return sysUserMapper.selectByName(principal.getName());
    }

    /**
     * 通过用户名获取
     * @param username
     * @return
     */
    public Map<String, Boolean> getUserByAccount(String username,boolean need) {
        SysUser sysUser = sysUserMapper.selectByName(username);
        Map<String,Boolean> validMap = new HashMap<>(1);
        if(sysUser==null){
            if(need){
                validMap.put("valid",true);
            } else {
                validMap.put("valid",false);
            }
        }else {
            if(need){
                validMap.put("valid",false);
            } else {
                validMap.put("valid",true);
            }
        }
        return validMap;
    }


    /**
     * @Author chenting
     * @Description  新增员工
     * @Date 23:32 2020/6/6
     * @Param [sysUser]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg saveStaff(SysUser sysUser, HttpServletRequest request) throws Exception {

        Date date = new Date() ;
        sysUser.setUpdateTime(date);
        sysUser.setUpdateUser(getUser(request).getId());

        if(BaseUtil.isBlank(sysUser.getId())) {
            sysUser.setCreateTime(date) ;
            sysUser.setCreateUser(getUser(request).getId());
            if(sysUserMapper.insertSelective(sysUser) == 0) {
                return Msg.fail("添加员工失败") ;
            }
        }else {
            if(sysUserMapper.updateByPrimaryKeySelective(sysUser) == 0 || sysUserRoleRelationMapper.deleteByUserId(sysUser.getId()) == 0) {
                return Msg.fail("修改员工信息失败") ;
            }
        }

        //清空用户的角色
        sysUserRoleRelationMapper.deleteByUserId(sysUser.getId()) ;
        //清空用户的权限
        sysUserPermissionRelationMapper.deleteByUserId(sysUser.getId()) ;
        //设置用户的角色
        SysUserRoleRelation sysUserRoleRelation = new SysUserRoleRelation() ;

        for(SysRole sysRole : sysUser.getSysRoleList()) {
            sysUserRoleRelation.setUserId(sysUser.getId());
            sysUserRoleRelation.setRoleId(sysRole.getId());
            if(sysUserRoleRelationMapper.insertSelective(sysUserRoleRelation) == 0) {
                throw new Exception("设置用户角色失败") ;
            }
        }
        //设置用户权限
        SysUserPermissionRelation sysUserPermissionRelation = new SysUserPermissionRelation() ;
        for(SysPermission sysPermission : sysUser.getSysPermissionList()) {
            sysUserPermissionRelation.setUserId(sysUser.getId());
            sysUserPermissionRelation.setPermissionId(sysPermission.getId());
            if(sysUserPermissionRelationMapper.insertSelective(sysUserPermissionRelation) == 0) {
                throw new Exception("设置用户权限失败") ;
            }
        }
        return Msg.success("更新员工信息成功") ;
    }

}
