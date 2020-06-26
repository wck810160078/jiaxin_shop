package com.jiaxin.shop.service;

import com.jiaxin.shop.pojo.StockImg;
import com.jiaxin.shop.utils.Msg;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public interface StockImgService {

    /**
     * @Author chenting
     * @Description // 上传图片信息到本地/服务器
     * @Date 12:38 2020/6/4
     * @Param [stockImgFile]
     * @return java.lang.String
     **/
    String uploadStockImg(MultipartFile stockImgFile) throws IOException;

    /**
     * @Author chenting
     * @Description // 新增库存图片信息
     * @Date 12:38 2020/6/4
     * @Param [stockImg]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg saveStockImg(StockImg stockImg);
}
