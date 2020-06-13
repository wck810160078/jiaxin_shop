package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.Stock;
import com.jiaxin.shop.service.StockService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class StockController {

    @Resource
    private StockService stockService ;

    /**
     * @Author chenting
     * @Description  新增库存信息 
     * @Date 20:10 2020/5/26
     * @Param [stock]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/staff/saveStock")
    public Msg saveStock(@RequestBody Stock stock) throws Exception {
        if(BaseUtil.isBlank(stock.getStockName())) {
            return Msg.fail("缺少关键参数");
        }
        return stockService.saveStock(stock) ;
    }

    /**
     * @Author chenting
     * @Description   根据标签（产品、原材料、包装材料）获取库存信息
     * @Date 23:46 2020/5/27
     * @Param [stockPageData]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/staff/getStockListByLabel")
    public Msg getStockListByLabel(@RequestBody PageData<Stock> stockPageData) {
//        if(BaseUtil.isBlank(stockPageData.getParamObj().getLabel())) {
//            return Msg.fail("缺少关键参数") ;
//        }
        return stockService.getStockListByLabel(stockPageData) ;
    }

    /**
     * @Author chenting
     * @Description  批量修改库存信息状态
     * @Date 21:59 2020/6/4
     * @Param [stockIds, state] state:修改后的状态
     * @return com.jiaxin.shop.utils.Msg
     **/
    @GetMapping("staff/changeStockState")
    public Msg changeStockState(@RequestParam Integer[] stockIds,String state) {
        if(stockIds.length == 0) {
            return Msg.fail("缺少关键参数") ;
        }
        return stockService.changeStockState(stockIds,state) ;
    }

    /**
     * @Author chenting
     * @Description  导入库存信息 
     * @Date 17:50 2020/5/29
     * @Param [excelFile]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/staff/importStocks")
    public Msg importStocks(@RequestParam MultipartFile excelFile,@RequestParam Integer label) throws IOException {
        return stockService.importStocks(excelFile,label) ;
    }

    /**
     * @Author chenting
     * @Description  导出库存信息
     * @Date 23:20 2020/6/1
     * @Param [label]
     **/
    @GetMapping("/staff/exportStocks")
    public Object exportStocks(@RequestParam Integer label,HttpServletResponse response) throws IOException {
        stockService.exportStocks(label,response);
        return null;
    }
    
    /**
     * @Author chenting
     * @Description  根据库存id查询库存信息
     * @Date 23:40 2020/6/9
     * @Param [stockId]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @GetMapping("/staff/selectStockByPrimaryKey")
    public Msg selectStockByPrimaryKey(@RequestParam Integer stockId) {
        if(BaseUtil.isBlank(stockId)) {
            return Msg.fail("缺少关键参数-库存信息") ;
        }
        return stockService.selectStockByPrimaryKey(stockId) ;
    }

}
