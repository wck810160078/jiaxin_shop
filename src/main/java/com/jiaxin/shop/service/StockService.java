package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.StockImgMapper;
import com.jiaxin.shop.dao.StockMapper;
import com.jiaxin.shop.pojo.Stock;
import com.jiaxin.shop.pojo.StockImg;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.ExcelUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class StockService {

    @Resource
    private StockMapper stockMapper ;

    @Resource
    private StockImgMapper stockImgMapper ;

    /**
     * @Author chenting
     * @Description  新增库存信息 
     * @Date 23:23 2020/5/27
     * @Param [stock]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg saveStock(Stock stock) throws Exception {
        Integer stockId = stock.getStockId() ;
        //判断改条库存信息是否有id，如果有则修改，没有则新增
        if(BaseUtil.isBlank(stockId)) {
            if(stockMapper.insertStockSelective(stock) == 0) {
                return Msg.fail("新增库存信息失败") ;
            }
            if(stock.getStockImgList() != null && stock.getStockImgList().size() > 0) {
                for(StockImg stockImg : stock.getStockImgList()) {
                    stockImg.setStockId(stock.getStockId());
                    if(stockImgMapper.insertSelective(stockImg) == 0) {
                        throw new Exception("插入图片失败") ;
                    }
                }
            }
            return Msg.success("新增库存信息成功") ;
        }else {
            if(stockImgMapper.closeImgByStockId(stockId) == 0) {
                throw new Exception("修改图片失败") ;
            }
            if(stock.getStockImgList() != null && stock.getStockImgList().size() > 0) {
                for(StockImg stockImg : stock.getStockImgList()) {
                    stockImg.setStockId(stock.getStockId());
                    if(stockImgMapper.insertSelective(stockImg) == 0) {
                        throw new Exception("插入图片失败") ;
                    }
                }
            }
            return Msg.success("修改库存信息成功") ;
        }
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
    public Msg importStocks(MultipartFile excelFile,Integer label) throws IOException {
//        boolean isExcel2007 = false ;
//        if(excelFile.getOriginalFilename().endsWith("xlsx")) {
//            isExcel2007 = true ;
//        }
//      根据文件格式(2003或者2007)来初始化
        Workbook workbook  = ExcelUtil.initExcel(excelFile);

//        if(isExcel2007) {
//            workbook = new XSSFWorkbook(excelFile.getInputStream()) ;
//        }else {
//            workbook = new HSSFWorkbook(excelFile.getInputStream()) ;
//        }
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
        BigDecimal purchasePrice = new BigDecimal(0);
        //零售价
        BigDecimal retailPrice = new BigDecimal(0) ;
        //批发价
        BigDecimal wholesalePrice = new BigDecimal(0) ;
        //供货商
        String supplier = "";
        //当前库存数量
        BigDecimal stockNow = new BigDecimal(0) ;
        //最低库存数量
        BigDecimal stockLowest = new BigDecimal(0) ;
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
                purchasePrice = new BigDecimal(purchasePriceCell.getNumericCellValue()) ;
            }
            Cell retailPriceCell = row.getCell(5) ;
            if(retailPriceCell != null && retailPriceCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                retailPrice = new BigDecimal(retailPriceCell.getNumericCellValue())  ;
            }
            Cell wholesalePriceCell = row.getCell(6) ;
            if(wholesalePriceCell != null && wholesalePriceCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                wholesalePrice = new BigDecimal(wholesalePriceCell.getNumericCellValue())  ;
            }
            Cell supplierCell = row.getCell(7) ;
            if(supplierCell != null && supplierCell.getCellType() == Cell.CELL_TYPE_STRING) {
                supplier = supplierCell.getStringCellValue() ;
            }
            Cell stockNowCell = row.getCell(8) ;
            if(stockNowCell != null && stockNowCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                stockNow = new BigDecimal (stockNowCell.getNumericCellValue()) ;
            }
            Cell stockLowestCell = row.getCell(9) ;
            if(stockLowestCell != null && stockLowestCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                stockLowest = new BigDecimal(stockLowestCell.getNumericCellValue()) ;
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
    public XSSFWorkbook exportStocks(Integer label,HttpServletResponse response) throws IOException {
        //获取要导出的库存信息
        List<Stock> stockList = stockMapper.getExportStockListByLabel(label) ;

        //判断标签内容（1:产品、2:原料、3:包装材料）
        String labelContent  ;
        switch (label) {
            case 1 : labelContent = "产品" ; break;
            case 2 : labelContent = "原料" ; break;
            case 3 : labelContent = "包装材料" ;break;
            default: labelContent = "其他" ;break;
        }
        //表头
        String title = labelContent + "信息_全部类别" ;
        //标题
        String[] headers = {"库存名称规格","货品类别","主计量单位","货品介绍","进货价","零售价","批发价","供货商","当前库存数量"
                ,"最低库存数量","备注","创建时间","上次修改时间"} ;
        String fileName = labelContent + "信息_全部类别" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xlsx" ;
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //创建工作簿对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook() ;
        //创建工作表对象
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("sheet1") ;
        //设置表头
        ExcelUtil.creatExcelTitle(xssfWorkbook,xssfSheet,title,headers.length -1);
        //设置标题
        ExcelUtil.creatExcelHeader(xssfWorkbook,xssfSheet,headers);

        //设置内容
        Stock stock;
        for (int i = 0 ; i < stockList.size() ; i++ ) {
            //创建行（内容行）
            XSSFRow xssfRowContent = xssfSheet.createRow(i + 2) ;
            stock = stockList.get(i) ;

            //设置数据格式
            XSSFDataFormat xssfDataFormat = xssfWorkbook.createDataFormat();

            //库存名称规格单元格
            XSSFCell xssfCellContent0 = xssfRowContent.createCell(0) ;
            xssfCellContent0.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,false));
            xssfCellContent0.setCellValue(ExcelUtil.isNull(stock.getStockName()));
            //货品类别单元格
            XSSFCell xssfCellContent1 = xssfRowContent.createCell(1) ;
            xssfCellContent1.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,false)) ;
            xssfCellContent1.setCellValue(ExcelUtil.isNull(stock.getStockType()));
            //主计量单位单元格
            XSSFCell xssfCellContent2 = xssfRowContent.createCell(2) ;
            xssfCellContent2.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,false));
            xssfCellContent2.setCellValue(ExcelUtil.isNull(stock.getUnit()));
            //货品介绍单元格
            XSSFCell xssfCellContent3 = xssfRowContent.createCell(3) ;
            xssfCellContent3.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,false));
            xssfCellContent3.setCellValue(ExcelUtil.isNull(stock.getIntroduction()));
            //进货价单元格
            XSSFCell xssfCellContent4 = xssfRowContent.createCell(4) ;
            xssfCellContent4.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,true));
            xssfCellContent4.setCellValue(ExcelUtil.isZero(stock.getPurchasePrice()).doubleValue());
            //零售价单元格
            XSSFCell xssfCellContent5 = xssfRowContent.createCell(5) ;
            xssfCellContent5.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,true));
            xssfCellContent5.setCellValue(ExcelUtil.isZero(stock.getRetailPrice()).doubleValue());
            //批发价单元格
            XSSFCell xssfCellContent6 = xssfRowContent.createCell(6) ;
            xssfCellContent6.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,true));
            xssfCellContent6.setCellValue(ExcelUtil.isZero(stock.getWholesalePrice()).doubleValue());
            //供货商单元格
            XSSFCell xssfCellContent7 = xssfRowContent.createCell(7) ;
            xssfCellContent7.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,false));
            xssfCellContent7.setCellValue(ExcelUtil.isNull(stock.getSupplier()));
            //当前库存数量单元格
            XSSFCell xssfCellContent8 = xssfRowContent.createCell(8) ;
            xssfCellContent8.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,true));
            xssfCellContent8.setCellValue(ExcelUtil.isZero(stock.getStockNow()).doubleValue());
            //最低库存数量单元格
            XSSFCell xssfCellContent9 = xssfRowContent.createCell(9) ;
            xssfCellContent9.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,true));
            xssfCellContent9.setCellValue(ExcelUtil.isZero(stock.getStockLowest()).doubleValue());
            //备注单元格
            XSSFCell xssfCellContent10 = xssfRowContent.createCell(10) ;
            xssfCellContent10.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,false));
            xssfCellContent10.setCellValue(ExcelUtil.isNull(stock.getRemark()));
            //创建时间单元格
            XSSFCell xssfCellContent11 = xssfRowContent.createCell(11) ;
            xssfCellContent11.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,false));
            xssfCellContent11.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stock.getCreatTime() == null ? new Date() :stock.getCreatTime()));
            //上次修改时间单元格
            XSSFCell xssfCellContent12 = xssfRowContent.createCell(12) ;
            xssfCellContent12.setCellStyle(ExcelUtil.contentCellStyle(xssfWorkbook,false));
            xssfCellContent12.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stock.getUpdateTime() == null ? new Date() :stock.getUpdateTime()));
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        //写入excel
        ExcelUtil.writeExcel(response,xssfWorkbook,os,fileName);

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

    /**
     * @Author chenting
     * @Description  根据库存id查询库存信息
     * @Date 23:44 2020/6/9
     * @Param [stockId]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg selectStockByPrimaryKey(Integer stockId) {
        Stock stock = stockMapper.selectByPrimaryKey(stockId) ;
        return Msg.success().setResp(stock) ;
    }

}
