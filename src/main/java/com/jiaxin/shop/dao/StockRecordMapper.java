package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.StockRecord;

public interface StockRecordMapper {
    /**
     *
     * @mbggenerated 2020-05-25
     */
    int deleteByPrimaryKey(Integer stockRecordId);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int insert(StockRecord record);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int insertSelective(StockRecord record);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    StockRecord selectByPrimaryKey(Integer stockRecordId);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int updateByPrimaryKeySelective(StockRecord record);

    /**
     *
     * @mbggenerated 2020-05-25
     */
    int updateByPrimaryKey(StockRecord record);
}