package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.SysPermissionMapper;
import com.jiaxin.shop.pojo.SysPermission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    public List<SysPermission> selectListByUser(Integer id) {
        List<SysPermission> sysPermissionList = sysPermissionMapper.selectListByUser(id);
        return sysPermissionList;
    }

    public List<SysPermission> selectListByPath(String requestUrl) {
        return sysPermissionMapper.selectListByPath(requestUrl);
    }
}
