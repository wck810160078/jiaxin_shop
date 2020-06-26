package com.jiaxin.shop.service.impl;

import com.jiaxin.shop.dao.SysRequestPathMapper;
import com.jiaxin.shop.pojo.SysRequestPath;
import com.jiaxin.shop.service.SysRequestPathService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysRequestPathServiceImpl implements SysRequestPathService {

    @Resource
    private SysRequestPathMapper sysRequestPathMapper;

    @Override
    public List<SysRequestPath> getAllPath() {
        return sysRequestPathMapper.getAllPath();
    }

}
