package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.SysRequestPath;

import java.util.List;

public interface SysRequestPathMapper {
    /**
     *
     * @mbggenerated 2020-05-17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insert(SysRequestPath record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insertSelective(SysRequestPath record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    SysRequestPath selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKeySelective(SysRequestPath record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKey(SysRequestPath record);

    /**
     * 获取权限路径
     * @return
     */
    List<SysRequestPath> getAllPath();
}