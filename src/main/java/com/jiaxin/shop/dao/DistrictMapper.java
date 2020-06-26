package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.District;

public interface DistrictMapper {
    /**
     *
     * @mbggenerated 2020-06-26
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int insert(District record);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int insertSelective(District record);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    District selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int updateByPrimaryKeySelective(District record);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int updateByPrimaryKey(District record);
}