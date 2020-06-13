package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.SysUserPermissionRelation;

public interface SysUserPermissionRelationMapper {
    /**
     *
     * @mbggenerated 2020-06-13
     */
    int insert(SysUserPermissionRelation record);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    int insertSelective(SysUserPermissionRelation record);

    int deleteByUserId(Integer id);
}