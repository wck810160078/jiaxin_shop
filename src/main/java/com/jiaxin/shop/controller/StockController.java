package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.Stock;
import com.jiaxin.shop.service.StockService;
import com.jiaxin.shop.service.SysUserService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class StockController {

    @Resource
    private StockService stockService ;

    /**
     * @Author chenting
     * @Description // 新增库存信息 
     * @Date 20:10 2020/5/26
     * @Param [stock]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/staff/saveStock")
    public Msg saveStock(@RequestBody Stock stock) {
        if(BaseUtil.isBlank(stock.getStockName())) {
            return Msg.fail("缺少关键参数");
        }
        return stockService.saveStock(stock) ;
    }

    /**
     * @Author chenting
     * @Description //  根据标签（产品、原材料、包装材料）获取库存信息
     * @Date 23:46 2020/5/27
     * @Param [stockPageData]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/staff/getStockListByLabel")
    public Msg getStockListByLabel(@RequestBody PageData<Stock> stockPageData) {
        if(BaseUtil.isBlank(stockPageData.getParamObj().getLabel())) {
            return Msg.fail("缺少关键参数") ;
        }
        return stockService.getStockListByLabel(stockPageData) ;
    }

    /**
     * @Author chenting
     * @Description // 批量修改库存信息状态
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
     * @Description // 导入库存信息 
     * @Date 17:50 2020/5/29
     * @Param [excelFile]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/staff/importStocks")
    public Msg importStocks(@RequestParam MultipartFile excelFile,@RequestParam String label) throws IOException {
        return stockService.importStocks(excelFile,label) ;
    }

    /**
     * @Author chenting
     * @Description // 导出库存信息
     * @Date 23:20 2020/6/1
     * @Param [label]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/staff/exportStocks")
    public Msg exportStocks(@RequestParam String label) throws IOException {
        return stockService.exportStocks(label);
    }
}
