package com.jiaxin.shop.controller;

import com.jiaxin.shop.service.StockImgService;
import com.jiaxin.shop.utils.Msg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

@RestController
public class StockImgController {

    @Resource
    private StockImgService stockImgService ;
    @Resource
    private HttpServletResponse response;

    /**
     * @Author chenting
     * @Description // 上传图片文件到本地/服务器
     * @Date 12:36 2020/6/4
     * @Param [stockImgFile]
     * @return java.lang.String
     **/
    @PostMapping("/uploadStockImg")
    public Msg uploadStockImg(@RequestParam MultipartFile stockImgFile) throws IOException {
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

    /**
     * @Author chenting
     * @Description  根据图片路径获取图片 
     * @Date 19:26 2020/6/11
     * @Param [imgPath, response]
     * @return void
     **/
    @GetMapping("/getImg")
    public void getImg(String imgPath) throws IOException {
        System.out.println("<<<<<<<<<<<<<<<<<<---------------------加载了图片："+imgPath+"------------------------>>>>>>>>>>>>");
        //加载图片
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(imgPath)) ;
        //设置response
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //将图片传输到Servlet输出流中
        ServletOutputStream outputStream = response.getOutputStream() ;
        String filePath = imgPath.substring(imgPath.lastIndexOf(".")+1) ;
        ImageIO.write(bufferedImage,filePath,outputStream) ;
        outputStream.close();
    }
}
