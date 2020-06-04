package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.StockImgMapper;
import com.jiaxin.shop.pojo.StockImg;
import com.jiaxin.shop.utils.Msg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;

@Service
public class StockImgService {

    @Resource
    private StockImgMapper stockImgMapper ;

    @Value("${upload-file-path}")
    private String uploadFilePath ;

    /**
     * @Author chenting
     * @Description // 上传图片信息到本地/服务器
     * @Date 12:38 2020/6/4
     * @Param [stockImgFile]
     * @return java.lang.String
     **/
    public String uploadStockImg(MultipartFile stockImgFile) throws IOException {
        String suffix = stockImgFile.getOriginalFilename().substring(stockImgFile.getOriginalFilename().lastIndexOf(".")) ;
        InputStream inputStream = null ;
        OutputStream outputStream = null ;
        String outFile = null ;

        try {
            //io存文件
            inputStream = stockImgFile.getInputStream() ;
            File file = new File(uploadFilePath) ;
            if(! file.exists()) {
                file.mkdirs() ;
            }
            outFile = uploadFilePath + "/" +System.currentTimeMillis() +suffix ;
            outputStream = new FileOutputStream(outFile) ;
            int len ;
            byte[] b = new byte[1024] ;
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();
        }
        return outFile ;
    }

    /**
     * @Author chenting
     * @Description // 新增库存图片信息
     * @Date 12:38 2020/6/4
     * @Param [stockImg]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg saveStockImg(StockImg stockImg) {
        return stockImgMapper.insertSelective(stockImg) == 0 ? Msg.fail("图片上传失败") : Msg.success("图片上传成功");
    }
}
