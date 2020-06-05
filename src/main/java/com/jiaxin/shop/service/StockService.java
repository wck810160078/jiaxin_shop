package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.StockMapper;
import com.jiaxin.shop.pojo.Stock;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class StockService {

    @Resource
    private StockMapper stockMapper ;

    /**
     * @Author chenting
     * @Description  新增库存信息 
     * @Date 23:23 2020/5/27
     * @Param [stock]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg saveStock(Stock stock) {
        //判断改条库存信息是否有id，如果有则修改，没有则新增
        if(BaseUtil.isBlank(stock.getStockId())) {
            return stockMapper.insertSelective(stock) == 0 ? Msg.fail("新增失败") : Msg.success("新增成功");
        }
        return stockMapper.updateByPrimaryKeySelective(stock) == 0 ? Msg.fail("修改失败") : Msg.success("修改成功") ;
    }

    /**
     * @Author chenting
     * @Description  根据标签获取库存列表 
     * @Date 20:36 2020/5/28
     * @Param [stockPageData]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg getStockListByLabel(PageData<Stock> stockPageData) {
        //如果查询条件不为空，则添加%
        if(stockPageData.getParamObj().getStockSearchContent() != null) {
            stockPageData.getParamObj().setStockSearchContent("%"+stockPageData.getParamObj().getStockSearchContent()+"%");
        }
        //获取查询到的库存信息
        List<Stock> stockList = stockMapper.getStockListByLabel(stockPageData) ;
        //获取查询到的库存信息总条数
        Long count = stockMapper.getStockCountByLabel(stockPageData.getParamObj()) ;

        stockPageData.setTotal(count);
        stockPageData.setRows(stockList);

        stockPageData.setParamObj(null);

        return Msg.success().setResp(stockPageData) ;
    }

    /**
     * @Author chenting
     * @Description  导入库存信息 
     * @Date 22:47 2020/6/1
     * @Param [excelFile, label]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg importStocks(MultipartFile excelFile,String label) throws IOException {
        boolean isExcel2007 = false ;
        if(excelFile.getOriginalFilename().endsWith("xlsx")) {
            isExcel2007 = true ;
        }
        Workbook workbook ;
        //根据文件格式(2003或者2007)来初始化
        if(isExcel2007) {
            workbook = new XSSFWorkbook(excelFile.getInputStream()) ;
        }else {
            workbook = new HSSFWorkbook(excelFile.getInputStream()) ;
        }
        Sheet sheet = workbook.getSheetAt(0) ;
        int totalRowNum = sheet.getLastRowNum() ;
//      从表格中获取到的参数
        //库存名称规格
        String stockName = "" ;
        //货品类别
        String stockType = "" ;
        //主计量单位
        String unit = "" ;
        //库存介绍
        String introduction = "" ;
        //进货价
        Double purchasePrice = 0.0 ;
        //零售价
        Double retailPrice = 0.0 ;
        //批发价
        Double wholesalePrice = 0.0 ;
        //供货商
        String supplier = "";
        //当前库存数量
        Integer stockNow = 0 ;
        //最低库存数量
        Integer stockLowest = 0 ;
        //备注
        String remark = "" ;
        for (int i = 4 ; i < totalRowNum ; i++) {
            //获取第i行数据
            Row row = sheet.getRow(i) ;
            Cell stockNameCell = row.getCell(0) ;
            if(stockNameCell != null && stockNameCell.getCellType() == Cell.CELL_TYPE_STRING) {
                stockName = stockNameCell.getStringCellValue() ;
            }
            Cell stockTypeCell = row.getCell(1) ;
            if(stockTypeCell != null && stockTypeCell.getCellType() == Cell.CELL_TYPE_STRING) {
                stockType = stockTypeCell.getStringCellValue() ;
            }
            Cell unitCell = row.getCell(2) ;
            if(unitCell != null && unitCell.getCellType() == Cell.CELL_TYPE_STRING) {
                unit = unitCell.getStringCellValue() ;
            }
            Cell introductionCell = row.getCell(3) ;
            if(introductionCell != null && introductionCell.getCellType() == Cell.CELL_TYPE_STRING) {
                introduction = introductionCell.getStringCellValue() ;
            }
            Cell purchasePriceCell = row.getCell(4) ;
            if(purchasePriceCell != null && purchasePriceCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                purchasePrice = purchasePriceCell.getNumericCellValue() ;
            }
            Cell retailPriceCell = row.getCell(5) ;
            if(retailPriceCell != null && retailPriceCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                retailPrice = retailPriceCell.getNumericCellValue() ;
            }
            Cell wholesalePriceCell = row.getCell(6) ;
            if(wholesalePriceCell != null && wholesalePriceCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                wholesalePrice = wholesalePriceCell.getNumericCellValue() ;
            }
            Cell supplierCell = row.getCell(7) ;
            if(supplierCell != null && supplierCell.getCellType() == Cell.CELL_TYPE_STRING) {
                supplier = supplierCell.getStringCellValue() ;
            }
            Cell stockNowCell = row.getCell(8) ;
            if(stockNowCell != null && stockNowCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                stockNow = (int)stockNowCell.getNumericCellValue() ;
            }
            Cell stockLowestCell = row.getCell(9) ;
            if(stockLowestCell != null && stockLowestCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                stockLowest = (int)stockLowestCell.getNumericCellValue() ;
            }
            Cell remarkCell = row.getCell(10) ;
            if(remarkCell != null && remarkCell.getCellType() == Cell.CELL_TYPE_STRING) {
                remark = remarkCell.getStringCellValue() ;
            }

            Date date = new Date() ;
            //查询库存信息是否已存在,若不存在则新增，若已存在则修改
            Stock stockOld = stockMapper.getStockByName(stockName) ;
            Stock stockNew = new Stock(stockName,stockType,unit,supplier,stockNow,stockNow,stockLowest,retailPrice,purchasePrice,wholesalePrice,label,introduction,"open",remark) ;
            stockNew.setUpdateTime(date);
            if(stockOld == null) {
                stockNew.setCreatTime(date);
                stockMapper.insertSelective(stockNew) ;
            }else {
                stockNew.setStockId(stockOld.getStockId());
                stockMapper.updateByPrimaryKeySelective(stockNew) ;
            }
        }
        return Msg.success("导入成功") ;
    }

    /**
     * @Author chenting
     * @Description  导出库存信息
     * @Date 23:21 2020/6/1
     * @Param [label]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public XSSFWorkbook exportStocks(String label, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取要导出的库存信息
        List<Stock> stockList = stockMapper.getExportStockListByLabel(label) ;
        //创建工作簿对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook() ;
        //创建工作表对象
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("sheet1") ;
        //创建行(表头行)
        XSSFRow xssfRowHeader = xssfSheet.createRow(0) ;
        //创建列（表头列）
        XSSFCell xssfCellHeader = xssfRowHeader.createCell(0) ;
        xssfCellHeader.setCellValue("库存信息_全部类别");
//        合并单元格（合并列）
//        CellRangeAddress(firstRow, lastRow, firstCol, lastCol)，参数的说明：
//        firstRow 区域中第一个单元格的行号
//        lastRow 区域中最后一个单元格的行号
//        firstCol 区域中第一个单元格的列号
//        lastCol 区域中最后一个单元格的列号
        CellRangeAddress cellRangeAddressHeader = new CellRangeAddress(0,0,0,12) ;
        xssfSheet.addMergedRegion(cellRangeAddressHeader);
        //创建单元格样式（表头）
        XSSFCellStyle xssfCellStyleHeader = xssfWorkbook.createCellStyle() ;
        //设置单元格样式
        xssfCellStyleHeader.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        xssfCellStyleHeader.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
        //创建字体样式（表头）
        XSSFFont xssfFontHeader = xssfWorkbook.createFont() ;
        xssfFontHeader.setFontName("宋体");//设置字体名称
        xssfFontHeader.setFontHeightInPoints((short) 18);//设置字号
        xssfFontHeader.setBold(true);//加粗
        xssfCellStyleHeader.setFont(xssfFontHeader);
        xssfCellHeader.setCellStyle(xssfCellStyleHeader);

        //创建行（标题行）
        XSSFRow xssfRowTitle = xssfSheet.createRow(1) ;
        String[] title = {"库存名称规格","货品类别","主计量单位","货品介绍","进货价","零售价","批发价","供货商","当前库存数量"
                ,"最低库存数量","备注","创建时间","上次修改时间"} ;
        //设置单元格宽度
        xssfSheet.setColumnWidth(0,14*256);
        xssfSheet.setColumnWidth(1,10*256);
        xssfSheet.setColumnWidth(2,12*256);
        xssfSheet.setColumnWidth(3,14*256);
        xssfSheet.setColumnWidth(4,8*256);
        xssfSheet.setColumnWidth(5,8*256);
        xssfSheet.setColumnWidth(6,8*256);
        xssfSheet.setColumnWidth(7,16*256);
        xssfSheet.setColumnWidth(8,14*256);
        xssfSheet.setColumnWidth(9,14*256);
        xssfSheet.setColumnWidth(10,10*256);
        xssfSheet.setColumnWidth(11,18*256);
        xssfSheet.setColumnWidth(12,18*256);
        //创建单元格样式（标题）
        XSSFCellStyle xssfCellStyleTitle = xssfWorkbook.createCellStyle() ;
        //设置单元格样式
        xssfCellStyleTitle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        xssfCellStyleTitle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
        //创建字体样式（标题）
        XSSFFont xssfFontTitle = xssfWorkbook.createFont() ;
        xssfFontTitle.setFontName("宋体");//设置字体名称
        xssfFontTitle.setFontHeightInPoints((short) 12);//设置字号
        xssfFontTitle.setBold(true);//加粗
        xssfCellStyleTitle.setFont(xssfFontTitle);
        for (int i = 0 ; i < title.length ; i++) {
            //创建列（标题列）
            XSSFCell xssfCellTitle = xssfRowTitle.createCell(i) ;
            xssfCellTitle.setCellValue(title[i]);
            xssfCellTitle.setCellStyle(xssfCellStyleTitle);
        }

        //创建单元格样式（内容）
        XSSFCellStyle xssfCellStyleContent = xssfWorkbook.createCellStyle() ;
        //设置单元格样式
        xssfCellStyleContent.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        xssfCellStyleContent.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
        xssfCellStyleContent.setWrapText(true);//自动换行
        //创建字体样式（内容）
        XSSFFont xssfFontContent = xssfWorkbook.createFont() ;
        xssfFontContent.setFontName("宋体");//设置字体名称
        xssfFontContent.setFontHeightInPoints((short) 10);//设置字号

        xssfCellStyleContent.setFont(xssfFontContent);
        Stock stock;
        for (int i = 0 ; i < stockList.size() ; i++ ) {
            //创建行（内容行）
            XSSFRow xssfRowContent = xssfSheet.createRow(i + 2) ;
            stock = stockList.get(i) ;

            //库存名称规格单元格
            XSSFCell xssfCellContent0 = xssfRowContent.createCell(0) ;
            xssfCellContent0.setCellStyle(xssfCellStyleContent);
            xssfCellContent0.setCellValue(stock.getStockName());
            //货品类别单元格
            XSSFCell xssfCellContent1 = xssfRowContent.createCell(1) ;
            xssfCellContent1.setCellStyle(xssfCellStyleContent);
            xssfCellContent1.setCellValue(stock.getStockType() == null ? "" :stock.getStockType());
            //主计量单位单元格
            XSSFCell xssfCellContent2 = xssfRowContent.createCell(2) ;
            xssfCellContent2.setCellStyle(xssfCellStyleContent);
            xssfCellContent2.setCellValue(stock.getUnit() == null ? "" :stock.getUnit());
            //货品介绍单元格
            XSSFCell xssfCellContent3 = xssfRowContent.createCell(3) ;
            xssfCellContent3.setCellStyle(xssfCellStyleContent);
            xssfCellContent3.setCellValue(stock.getIntroduction() == null ? "" :stock.getIntroduction());
            //进货价单元格
            XSSFCell xssfCellContent4 = xssfRowContent.createCell(4) ;
            xssfCellContent4.setCellStyle(xssfCellStyleContent);
            xssfCellContent4.setCellValue(stock.getPurchasePrice() == null ? 0.0 :stock.getPurchasePrice());
            //零售价单元格
            XSSFCell xssfCellContent5 = xssfRowContent.createCell(5) ;
            xssfCellContent5.setCellStyle(xssfCellStyleContent);
            xssfCellContent5.setCellValue(stock.getRetailPrice() == null ? 0.0 :stock.getRetailPrice());
            //批发价单元格
            XSSFCell xssfCellContent6 = xssfRowContent.createCell(6) ;
            xssfCellContent6.setCellStyle(xssfCellStyleContent);
            xssfCellContent6.setCellValue(stock.getWholesalePrice() == null ? 0.0 :stock.getWholesalePrice());
            //供货商单元格
            XSSFCell xssfCellContent7 = xssfRowContent.createCell(7) ;
            xssfCellContent7.setCellStyle(xssfCellStyleContent);
            xssfCellContent7.setCellValue(stock.getSupplier() == null ? "" :stock.getSupplier());
            //当前库存数量单元格
            XSSFCell xssfCellContent8 = xssfRowContent.createCell(8) ;
            xssfCellContent8.setCellStyle(xssfCellStyleContent);
            xssfCellContent8.setCellValue(stock.getStockNow() == null ? 0.0 :stock.getStockNow());
            //最低库存数量单元格
            XSSFCell xssfCellContent9 = xssfRowContent.createCell(9) ;
            xssfCellContent9.setCellStyle(xssfCellStyleContent);
            xssfCellContent9.setCellValue(stock.getStockLowest() == null ? 0.0 :stock.getStockLowest());
            //备注单元格
            XSSFCell xssfCellContent10 = xssfRowContent.createCell(10) ;
            xssfCellContent10.setCellStyle(xssfCellStyleContent);
            xssfCellContent10.setCellValue(stock.getRemark() == null ? "" :stock.getRemark());
            //创建时间单元格
            XSSFCell xssfCellContent11 = xssfRowContent.createCell(11) ;
            xssfCellContent11.setCellStyle(xssfCellStyleContent);
            xssfCellContent11.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stock.getCreatTime() == null ? new Date() :stock.getCreatTime()));
            //上次修改时间单元格
            XSSFCell xssfCellContent12 = xssfRowContent.createCell(12) ;
            xssfCellContent12.setCellStyle(xssfCellStyleContent);
            xssfCellContent12.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stock.getUpdateTime() == null ? new Date() :stock.getUpdateTime()));
        }

        //文档输出
//        FileOutputStream out = new FileOutputStream("/库存信息_全部类别" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xlsx");
//        xssfWorkbook.write(out);
//        out.close();
//
//        return Msg.success("导出成功") ;
//        OutputStream os = response.getOutputStream();// 取得输出流
//        String fileName = "库存信息_全部类别" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xlsx" ;
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-disposition", "attachment;filename="+fileName);//默认Excel名称
//        response.flushBuffer();
//        xssfWorkbook.write(os);
        return xssfWorkbook ;
    }

    /**
     * @Author chenting
     * @Description  批量修改库存信息的状态
     * @Date 21:58 2020/6/4
     * @Param [stockIds, state] state:修改后的状态
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg changeStockState(Integer[] stockIds, String state) {
        Integer stockId ;
        Stock stock ;
        boolean flag = false ;
        for (Integer i: stockIds) {
            if(i == null) {
                return Msg.fail("缺少关键参数") ;
            }
            stockId = i ;
            stock = stockMapper.selectByPrimaryKey(stockId) ;
            stock.setState(state);
            if(stockMapper.updateByPrimaryKeySelective(stock) != 0) {
                flag = true ;
            }
        }
        if(flag) {
            return Msg.success("修改成功") ;
        }else {
            return Msg.fail("修改失败") ;
        }
    }
}
