package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.Stock;
import com.jiaxin.shop.service.StockService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public Msg saveStock(@RequestBody Stock stock) {
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
        if(BaseUtil.isBlank(stockPageData.getParamObj().getLabel())) {
            return Msg.fail("缺少关键参数") ;
        }
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
    public Msg importStocks(@RequestParam MultipartFile excelFile,@RequestParam String label) throws IOException {
        return stockService.importStocks(excelFile,label) ;
    }

    /**
     * @Author chenting
     * @Description  导出库存信息
     * @Date 23:20 2020/6/1
     * @Param [label]
     **/
    @GetMapping("/staff/exportStocks")
    public Object exportStocks(@RequestParam String label,HttpServletRequest request, HttpServletResponse response) throws IOException {
        XSSFWorkbook xssfWorkbook = stockService.exportStocks(label,request,response);
        String fileName = "库存信息_全部类别" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xlsx" ;
        fileName = URLEncoder.encode(fileName, "UTF-8");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            xssfWorkbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/x-download");
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        ServletOutputStream out = response.getOutputStream();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {

            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);

            byte[] buff = new byte[2048];
            int bytesRead;

            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }

        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
}
