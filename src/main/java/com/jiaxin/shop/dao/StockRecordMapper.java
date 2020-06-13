package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.StockRecord;
import com.jiaxin.shop.utils.PageData;

import java.util.List;

public interface StockRecordMapper {
    /**
     *
     * @mbggenerated 2020-06-09
     */
    int deleteByPrimaryKey(Integer stockRecordId);

    /**
     *
     * @mbggenerated 2020-06-09
     */
    int insert(StockRecord record);

    /**
     *
     * @mbggenerated 2020-06-09
     */
    int insertSelective(StockRecord record);

    /**
     *
     * @mbggenerated 2020-06-09
     */
    StockRecord selectByPrimaryKey(Integer stockRecordId);

    /**
     *
     * @mbggenerated 2020-06-09
     */
    int updateByPrimaryKeySelective(StockRecord record);

    /**
     *
     * @mbggenerated 2020-06-09
     */
    int updateByPrimaryKey(StockRecord record);

    List<StockRecord> getStockRecordList(PageData<StockRecord> stockRecordPageData);

    Long getStockRecordCount(StockRecord paramObj);
}