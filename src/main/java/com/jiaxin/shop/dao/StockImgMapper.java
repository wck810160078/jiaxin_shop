package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.StockImg;

public interface StockImgMapper {
    /**
     *
     * @mbggenerated 2020-05-25
     */
    int deleteByPrimaryKey(Integer stockImgId);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int insert(StockImg record);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int insertSelective(StockImg record);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    StockImg selectByPrimaryKey(Integer stockImgId);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int updateByPrimaryKeySelective(StockImg record);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int updateByPrimaryKey(StockImg record);

    int closeImgByStockId(Integer stockId);
}