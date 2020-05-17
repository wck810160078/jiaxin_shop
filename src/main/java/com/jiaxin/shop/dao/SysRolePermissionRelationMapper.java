package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.SysRolePermissionRelation;

public interface SysRolePermissionRelationMapper {
    /**
     *
     * @mbggenerated 2020-05-17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insert(SysRolePermissionRelation record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insertSelective(SysRolePermissionRelation record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    SysRolePermissionRelation selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKeySelective(SysRolePermissionRelation record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKey(SysRolePermissionRelation record);
}