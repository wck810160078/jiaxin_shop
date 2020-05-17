package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.SysUserMapper;
import com.jiaxin.shop.dao.SysUserRoleRelationMapper;
import com.jiaxin.shop.pojo.SysUser;
import com.jiaxin.shop.pojo.SysUserRoleRelation;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserRoleRelationMapper sysUserRoleRelationMapper;

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


}
