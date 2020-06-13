package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.StockRecord;
import com.jiaxin.shop.service.StockRecordService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class StockRecordController {

    @Resource
    private StockRecordService stockRecordService ;

    /**
     * @Author chenting
     * @Description  新增/修改库存记录
     * @Date 22:33 2020/6/9
     * @Param [stockRecord]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping(value = "/staff/saveStockRecord",produces = { "application/json;charset=UTF-8" })
    public Msg saveStockRecord(@RequestBody StockRecord stockRecord) throws Exception {
        if(BaseUtil.isBlank(stockRecord.getStockId())) {
            return Msg.fail("缺少关键参数-库存信息") ;
        }
        return stockRecordService.saveStockRecord(stockRecord) ;
    }
    
    
    /**
     * @Author chenting
     * @Description  根据起始日期、终止日期查询库存记录信息
     * @Date 15:59 2020/6/10
     * @Param [beginDate, endDate]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/staff/getStockRecordList")
    public Msg getStockRecordList(@RequestBody PageData<StockRecord> stockRecordPageData) {
        if(BaseUtil.isBlank(stockRecordPageData.getParamObj().getBeginDate())) {
            return Msg.fail("缺少关键参数-查询日期") ;
        }
        if(BaseUtil.isBlank(stockRecordPageData.getParamObj().getEndDate())) {
            stockRecordPageData.getParamObj().setEndDate(stockRecordPageData.getParamObj().getBeginDate());
        }
        return stockRecordService.getStockRecordList(stockRecordPageData) ;
    }
}
