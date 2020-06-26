package com.jiaxin.shop.service;

import com.jiaxin.shop.pojo.StockRecord;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;

public interface StockRecordService {

    /**
     * @Author chenting
     * @Description  新增/修改当日库存记录
     * @Date 23:02 2020/6/9
     * @Param [stockRecord]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg saveStockRecord(StockRecord stockRecord) throws Exception;


    /**
     * @Author chenting
     * @Description  根据起始日期、终止日期查询库存记录信息 
     * @Date 16:58 2020/6/10
     * @Param [stockRecordPageData]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg getStockRecordList(PageData<StockRecord> stockRecordPageData);

}
