package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.SysPermission;

import java.util.List;

public interface SysPermissionMapper {
    /**
     *
     * @mbggenerated 2020-05-17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insert(SysPermission record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insertSelective(SysPermission record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    SysPermission selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectListByUser(Integer userId);

    List<SysPermission> selectListByPath(String requestUrl);
}