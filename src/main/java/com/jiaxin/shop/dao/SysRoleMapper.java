package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.SysRole;

public interface SysRoleMapper {
    /**
     *
     * @mbggenerated 2020-05-17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insert(SysRole record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insertSelective(SysRole record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    SysRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKey(SysRole record);
}