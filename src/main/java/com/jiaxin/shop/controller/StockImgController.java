package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.StockImg;
import com.jiaxin.shop.service.StockImgService;
import com.jiaxin.shop.utils.Msg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;

@RestController
public class StockImgController {

    @Resource
    private StockImgService stockImgService ;

    /**
     * @Author chenting
     * @Description // 上传图片文件到本地/服务器
     * @Date 12:36 2020/6/4
     * @Param [stockImgFile]
     * @return java.lang.String
     **/
    @PostMapping("uploadStockImg")
    public Msg uploadStockImg(MultipartFile stockImgFile) throws IOException {
        if(stockImgFile == null) {
            return Msg.fail("请至少上传一张图片！") ;
        }
        String outFile = stockImgService.uploadStockImg(stockImgFile) ;
        return outFile == null ? Msg.fail("上传图片失败") : Msg.success("上传图片成功").setResp(outFile);
    }

    /**
     * @Author chenting
     * @Description // 新增库存图片信息
     * @Date 12:36 2020/6/4
     * @Param [stockImgFile, stockId]
     * @return com.jiaxin.shop.utils.Msg
     **/
//    public Msg saveStockImg(@RequestParam MultipartFile stockImgFile,Integer stockId) throws IOException {
//        String stockImgSrc = uploadStockImg(stockImgFile) ;
//        StockImg stockImg = new StockImg() ;
//        stockImg.setStockId(stockId);
//        stockImg.setStockImgSrc(stockImgSrc);
//        return stockImgService.saveStockImg(stockImg) ;
//    }
}
