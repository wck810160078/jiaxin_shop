package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.SysRequestPathMapper;
import com.jiaxin.shop.pojo.SysRequestPath;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysRequestPathService {

    @Resource
    private SysRequestPathMapper sysRequestPathMapper;

    public List<SysRequestPath> getAllPath() {
        return sysRequestPathMapper.getAllPath();
    }
}
