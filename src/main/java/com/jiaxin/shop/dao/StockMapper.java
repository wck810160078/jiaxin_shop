package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.Stock;

public interface StockMapper {
    /**
     *
     * @mbggenerated 2020-05-25
     */
    int deleteByPrimaryKey(Integer stockId);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int insert(Stock record);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int insertSelective(Stock record);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    Stock selectByPrimaryKey(Integer stockId);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int updateByPrimaryKeySelective(Stock record);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int updateByPrimaryKey(Stock record);
}