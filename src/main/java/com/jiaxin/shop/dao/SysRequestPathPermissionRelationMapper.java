package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.SysRequestPathPermissionRelation;

public interface SysRequestPathPermissionRelationMapper {
    /**
     *
     * @mbggenerated 2020-05-17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insert(SysRequestPathPermissionRelation record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insertSelective(SysRequestPathPermissionRelation record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    SysRequestPathPermissionRelation selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKeySelective(SysRequestPathPermissionRelation record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKey(SysRequestPathPermissionRelation record);
}