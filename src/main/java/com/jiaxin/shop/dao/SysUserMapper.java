package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.SysUser;

public interface SysUserMapper {
    /**
     *
     * @mbggenerated 2020-05-17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insert(SysUser record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int insertSelective(SysUser record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     *
     * @mbggenerated 2020-05-17
     */
    int updateByPrimaryKey(SysUser record);

    SysUser selectByName(String username);
}