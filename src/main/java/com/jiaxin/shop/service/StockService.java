package com.jiaxin.shop.service;

import com.jiaxin.shop.pojo.Stock;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface StockService {

    /**
     * @Author chenting
     * @Description  新增库存信息 
     * @Date 23:23 2020/5/27
     * @Param [stock]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg saveStock(Stock stock) throws Exception;

    /**
     * @Author chenting
     * @Description  根据标签获取库存列表 
     * @Date 20:36 2020/5/28
     * @Param [stockPageData]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg getStockListByLabel(PageData<Stock> stockPageData);

    /**
     * @Author chenting
     * @Description  导入库存信息 
     * @Date 22:47 2020/6/1
     * @Param [excelFile, label]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg importStocks(MultipartFile excelFile, Integer label) throws IOException;

    /**
     * @Author chenting
     * @Description  导出库存信息
     * @Date 23:21 2020/6/1
     * @Param [label]
     * @return com.jiaxin.shop.utils.Msg
     **/
    XSSFWorkbook exportStocks(Integer label, HttpServletResponse response) throws IOException;

    /**
     * @Author chenting
     * @Description  批量修改库存信息的状态
     * @Date 21:58 2020/6/4
     * @Param [stockIds, state] state:修改后的状态
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg changeStockState(Integer[] stockIds, String state);

    /**
     * @Author chenting
     * @Description  根据库存id查询库存信息
     * @Date 23:44 2020/6/9
     * @Param [stockId]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg selectStockByPrimaryKey(Integer stockId);

}
