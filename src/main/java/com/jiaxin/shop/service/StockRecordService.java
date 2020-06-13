package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.StockMapper;
import com.jiaxin.shop.dao.StockRecordMapper;
import com.jiaxin.shop.pojo.Stock;
import com.jiaxin.shop.pojo.StockRecord;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class StockRecordService {
    
    @Resource
    private StockRecordMapper stockRecordMapper ;

    @Resource
    private StockMapper stockMapper ;
    
    /**
     * @Author chenting
     * @Description  新增/修改当日库存记录
     * @Date 23:02 2020/6/9
     * @Param [stockRecord]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg saveStockRecord(StockRecord stockRecord) throws Exception {
        //填充数据到库存信息
        Stock stock = new Stock() ;
        stock.setStockId(stockRecord.getStockId()) ;
        stock.setStockNow(stockRecord.getNewNumber());
        //填充数据到库存记录信息
        Date date = new Date() ;
        stockRecord.setUpdateTime(date);
        //更新当前库存数量
        if(stockMapper.updateByPrimaryKeySelective(stock) == 0) {
            throw new Exception("更新当前库存数量失败") ;
        }
        if(BaseUtil.isBlank(stockRecord.getStockRecordId())) {
            stockRecord.setCreatTime(date);
            return stockRecordMapper.insertSelective(stockRecord) == 0 ? Msg.fail("新增库存记录信息失败") : Msg.success("新增库存记录信息成功") ;
        }
        return stockRecordMapper.updateByPrimaryKeySelective(stockRecord)  == 0 ? Msg.fail("修改当日记录信息失败") : Msg.success("修改当日记录信息成功") ;
    }


    /**
     * @Author chenting
     * @Description  根据起始日期、终止日期查询库存记录信息 
     * @Date 16:58 2020/6/10
     * @Param [stockRecordPageData]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg getStockRecordList(PageData<StockRecord> stockRecordPageData) {

        //获取查询到的库存记录信息
        List<StockRecord> stockRecordList = stockRecordMapper.getStockRecordList(stockRecordPageData) ;
        //获取查询到的库存记录总条数
        Long count = stockRecordMapper.getStockRecordCount(stockRecordPageData.getParamObj()) ;

        //填充结果
        stockRecordPageData.setTotal(count);
        stockRecordPageData.setRows(stockRecordList);
        
        stockRecordPageData.setParamObj(null);
        
        return Msg.success().setResp(stockRecordPageData) ;
    }

}
