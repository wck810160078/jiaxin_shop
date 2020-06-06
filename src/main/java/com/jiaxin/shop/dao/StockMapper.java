package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.Stock;
import com.jiaxin.shop.utils.PageData;

import java.util.List;

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

    List<Stock> getStockListByLabel(PageData<Stock> stockPageData);

    Long getStockCountByLabel(Stock paramObj);

    Stock getStockByName(String stockName);

    List<Stock> getExportStockListByLabel(String label);

    int insertStockSelective(Stock record);
}