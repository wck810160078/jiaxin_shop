package com.jiaxin.shop.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;

public class ExcelUtil {

    /**
     * @Author chenting
     * @Description  创建工作表
     * @Date 18:03 2020/6/5
     * @Param []
     * @return org.apache.poi.xssf.usermodel.XSSFSheet
     **/
    public static XSSFSheet creatExcel(XSSFWorkbook xssfWorkbook) {
        //创建工作簿对象
//        XSSFWorkbook xssfWorkbook = xssfWorkbook ;
        //创建工作表对象
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("sheet1") ;

        return xssfSheet ;
    }

    /**
     * @Author chenting
     * @Description  设置表头行
     * @Date 18:10 2020/6/5
     * @Param [title, lastCol] 表头，表头合并单元格长度
     * @return void
     **/
    public static  void creatExcelTitle(XSSFWorkbook xssfWorkbook,XSSFSheet xssfSheet,String title, int lastCol) {
//        XSSFSheet xssfSheet = creatExcel(xssfWorkbook) ;
        //创建行(表头行)
        XSSFRow xssfRowHeader = xssfSheet.createRow(0) ;
//        //创建列（表头列）
        XSSFCell xssfCellHeader = xssfRowHeader.createCell(0) ;
        xssfCellHeader.setCellValue(title);
//        合并单元格（合并列）
//        CellRangeAddress(firstRow, lastRow, firstCol, lastCol)，参数的说明：
//        firstRow 区域中第一个单元格的行号
//        lastRow 区域中最后一个单元格的行号
//        firstCol 区域中第一个单元格的列号
//        lastCol 区域中最后一个单元格的列号
        CellRangeAddress cellRangeAddressHeader = new CellRangeAddress(0,0,0,lastCol) ;
        xssfSheet.addMergedRegion(cellRangeAddressHeader);
        // 使用RegionUtil类为合并后的单元格添加边框
        RegionUtil.setBorderBottom(1, cellRangeAddressHeader, xssfSheet,xssfWorkbook); // 下边框
        RegionUtil.setBorderLeft(1, cellRangeAddressHeader, xssfSheet,xssfWorkbook); // 左边框
        RegionUtil.setBorderRight(1, cellRangeAddressHeader, xssfSheet,xssfWorkbook); // 有边框
        RegionUtil.setBorderTop(1, cellRangeAddressHeader, xssfSheet,xssfWorkbook); // 上边框
        xssfCellHeader.setCellStyle(titleCellStyle(xssfWorkbook));
    }

    /**
     * @Author chenting
     * @Description  设置标题行
     * @Date 18:14 2020/6/5
     * @Param [headers] 标题内容
     * @return void
     **/
    public static void creatExcelHeader(XSSFWorkbook xssfWorkbook,XSSFSheet xssfSheet,String[] headers) {
//        XSSFSheet xssfSheet = creatExcel(xssfWorkbook) ;
        //创建行（标题行）
        XSSFRow xssfRowTitle = xssfSheet.createRow(1) ;
        for (int i = 0 ; i < headers.length ; i++) {
            //创建列（标题列）
            XSSFCell xssfCellTitle = xssfRowTitle.createCell(i) ;
            //设置单元格宽度
            xssfSheet.setColumnWidth(i,12*256);
            xssfCellTitle.setCellValue(headers[i]);
            xssfCellTitle.setCellStyle(headerCellStyle(xssfWorkbook));
        }
    }

    /**
     * @Author chenting
     * @Description  表头单元格样式
     * @Date 17:35 2020/6/5
     * @Param [position]    单元格位置
     * @return org.apache.poi.xssf.usermodel.XSSFCellStyle
     **/
    public static XSSFCellStyle titleCellStyle(XSSFWorkbook xssfWorkbook) {
        //创建工作簿对象
//        XSSFWorkbook xssfWorkbook = new XSSFWorkbook() ;
        //创建单元格样式
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle() ;
        //设置单元格样式
        xssfCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        xssfCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
        //创建字体样式（表头）
        XSSFFont xssfFontHeader = xssfWorkbook.createFont() ;
        xssfFontHeader.setFontName("宋体");//设置字体名称
        xssfFontHeader.setFontHeightInPoints((short) 18);//设置字号
        xssfFontHeader.setBold(true);//加粗
        xssfCellStyle.setFont(xssfFontHeader);
        return xssfCellStyle ;
    }


    /**
     * @Author chenting
     * @Description  标题单元格样式
     * @Date 20:26 2020/6/5
     * @Param [xssfWorkbook]
     * @return org.apache.poi.xssf.usermodel.XSSFCellStyle
     **/
    public static XSSFCellStyle headerCellStyle(XSSFWorkbook xssfWorkbook) {
        //创建工作簿对象
//        XSSFWorkbook xssfWorkbook = new XSSFWorkbook() ;
        //创建单元格样式
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle() ;
        //设置单元格样式
        xssfCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        xssfCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
        //设置边框
        xssfCellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
        xssfCellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); // 下边框
        xssfCellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
        xssfCellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框

        //创建字体样式（标题）
        XSSFFont xssfFontTitle = xssfWorkbook.createFont() ;
        xssfFontTitle.setFontName("宋体");//设置字体名称
        xssfFontTitle.setFontHeightInPoints((short) 12);//设置字号
        xssfFontTitle.setBold(true);//加粗
        xssfCellStyle.setFont(xssfFontTitle);
//        xssfCellStyle.setWrapText(true);//自动换行
        return xssfCellStyle ;

    }

    /**
     * @Author chenting
     * @Description  内容行单元格样式
     * @Date 20:26 2020/6/5
     * @Param [xssfWorkbook]
     * @return org.apache.poi.xssf.usermodel.XSSFCellStyle
     **/
    public static XSSFCellStyle contentCellStyle(XSSFWorkbook xssfWorkbook,boolean isDouble) {
        //创建工作簿对象
//        XSSFWorkbook xssfWorkbook = new XSSFWorkbook() ;
        //创建单元格样式
        XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle() ;
        //此处设置数据格式
        XSSFDataFormat xssfDataFormat = xssfWorkbook.createDataFormat();
        //设置单元格样式
        xssfCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        xssfCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
        //设置边框
        xssfCellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
        xssfCellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); // 下边框
        xssfCellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
        xssfCellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框

        xssfCellStyle.setWrapText(true);//自动换行
        //创建字体样式（内容）
        XSSFFont xssfFontContent = xssfWorkbook.createFont() ;
        xssfFontContent.setFontName("宋体");//设置字体名称
        xssfFontContent.setFontHeightInPoints((short) 10);//设置字号
        xssfCellStyle.setFont(xssfFontContent);
        if(isDouble) {
            xssfCellStyle.setDataFormat(xssfDataFormat.getFormat("#,#0.000")); //小数点后保留三位
        }
        return xssfCellStyle ;
    }

    /**
     * @Author chenting
     * @Description  判断字符是否为空
     * @Date 18:24 2020/6/5
     * @Param [data]
     * @return java.lang.String
     **/
    public static String isNull(String data) {
        if(data == null) {
            return "" ;
        }
        return  data ;
    }

    /**
     * @Author chenting
     * @Description  判断Double类型数据是否为零
     * @Date 18:29 2020/6/5
     * @Param [data]
     * @return double
     **/
    public static BigDecimal isZero(BigDecimal data) {
        if(data == null) {
            return  new BigDecimal(0);
        }
        return data ;
    }
    
    /**
     * @Author chenting
     * @Description  判断Integer类型是否为零 
     * @Date 20:17 2020/6/5
     * @Param [data]
     * @return java.lang.Integer
     **/
    public static Integer isZero(Integer data) {
        if(data == null) {
            return 0 ;
        } 
        return data ;
    }

    /**
     * @Author chenting
     * @Description  写入excel
     * @Date 18:51 2020/6/5
     * @Param [response, xssfWorkbook, os]
     * @return void
     **/
    public static void writeExcel(HttpServletResponse response, XSSFWorkbook xssfWorkbook, ByteArrayOutputStream os,String fileName) throws IOException {
        try {
            xssfWorkbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        setResponse(response,fileName);

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

    }

    /**
     * @Author chenting
     * @Description  设置response参数，以打开下载界面
     * @Date 22:13 2020/6/9
     * @Param [response, fileName]
     * @return void
     **/
    public static void setResponse(HttpServletResponse response,String fileName) {
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/x-download");
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
    }


    /**
     * @Author chenting
     * @Description  导入excel文件，初始化workbook 
     * @Date 13:11 2020/6/13
     * @Param [excelFile]
     * @return org.apache.poi.ss.usermodel.Workbook
     **/
    public static Workbook initExcel(MultipartFile excelFile) throws IOException {
        boolean isExcel2007 = false ;
        if(excelFile.getOriginalFilename().endsWith("xlxs")) {
            isExcel2007 = true ;
        }

//        根据文件格式(2003或者2007)来初始化
        if(isExcel2007) {
            return new XSSFWorkbook(excelFile.getInputStream()) ;
        }else {
            return new HSSFWorkbook(excelFile.getInputStream()) ;
        }
    }
}
