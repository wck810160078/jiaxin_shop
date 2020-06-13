package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.SysPermission;
import com.jiaxin.shop.utils.PageData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPermissionMapper {
    /**
     *
     * @mbggenerated 2020-06-13
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    int insert(SysPermission record);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    int insertSelective(SysPermission record);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    SysPermission selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     *
     * @mbggenerated 2020-06-13
     */
    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectListByPath(String requestUrl);

    List<SysPermission> selectListByUser(Integer id);

    List<SysPermission> getSysPermissionList(@Param("parentId") Integer parentId);

//    Long getSysPermissionCount(Integer parentId);
}