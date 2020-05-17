package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.SysUserRoleRelation;

public interface SysUserRoleRelationMapper {
    /**
     *
     * @mbggenerated 2020-05-17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insert(SysUserRoleRelation record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insertSelective(SysUserRoleRelation record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    SysUserRoleRelation selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKeySelective(SysUserRoleRelation record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKey(SysUserRoleRelation record);

    Integer getRoleIdByUserId(Integer id);
}