package com.jiaxin.shop.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Stock {
    /**
     * 库存ID
     */
    private Integer stockId;

    /**
     * 库存名称规格
     */
    private String stockName;

    /**
     * 库存类别
     */
    private String stockType;

    /**
     * 单位
     */
    private String unit;

    /**
     * 供货商
     */
    private String supplier;

    /**
     * 初始库存数量
     */
    private BigDecimal stockInitial;

    /**
     * 当前库存数量
     */
    private BigDecimal stockNow;

    /**
     * 最低库存数量
     */
    private BigDecimal stockLowest;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 批发价
     */
    private BigDecimal wholesalePrice;

    /**
     * 库存标签（1:产品、2:原料、3:包装材料）
     */
    private Integer label;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

    //以下为自定义属性
    /**
     * 库存查询内容
     */
    private String stockSearchContent ;

    /**
     * 库存图片集合
     */
    private List<StockImg> stockImgList ;


    /**
     * @Author chenting
     * @Description  构造函数
     * @Date 20:58 2020/6/9
     * @Param []
     * @return 
     **/
    public Stock() {
    }

    /**
     * @Author chenting
     * @Description  构造函数
     * @Date 20:59 2020/6/9
     * @Param [stockName, stockType, unit, supplier, stockInitial, stockNow, stockLowest, retailPrice, purchasePrice, wholesalePrice, label, introduction, state, remark]
     * @return
     **/
    public Stock(String stockName, String stockType, String unit, String supplier, BigDecimal stockInitial, BigDecimal stockNow, BigDecimal stockLowest, BigDecimal retailPrice, BigDecimal purchasePrice, BigDecimal wholesalePrice, Integer label, String introduction,String state, String remark) {
        this.stockName = stockName;
        this.stockType = stockType;
        this.unit = unit;
        this.supplier = supplier;
        this.stockInitial = stockInitial;
        this.stockNow = stockNow;
        this.stockLowest = stockLowest;
        this.retailPrice = retailPrice;
        this.purchasePrice = purchasePrice;
        this.wholesalePrice = wholesalePrice;
        this.label = label;
        this.introduction = introduction;
        this.state = state;
        this.remark = remark;
    }

    /**
     *   get/set方法
     **/

    public String getStockSearchContent() {
        return stockSearchContent;
    }

    public void setStockSearchContent(String stockSearchContent) {
        this.stockSearchContent = stockSearchContent;
    }

    public List<StockImg> getStockImgList() {
        return stockImgList;
    }

    public void setStockImgList(List<StockImg> stockImgList) {
        this.stockImgList = stockImgList;
    }

    /**
     * 库存ID
     * @return stock_id 库存ID
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * 库存ID
     * @param stockId 库存ID
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * 库存名称规格
     * @return stock_name 库存名称规格
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * 库存名称规格
     * @param stockName 库存名称规格
     */
    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    /**
     * 库存类别
     * @return stock_type 库存类别
     */
    public String getStockType() {
        return stockType;
    }

    /**
     * 库存类别
     * @param stockType 库存类别
     */
    public void setStockType(String stockType) {
        this.stockType = stockType == null ? null : stockType.trim();
    }

    /**
     * 单位
     * @return unit 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 单位
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 供货商
     * @return supplier 供货商
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * 供货商
     * @param supplier 供货商
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    /**
     * 初始库存数量
     * @return stock_initial 初始库存数量
     */
    public BigDecimal getStockInitial() {
        return stockInitial;
    }

    /**
     * 初始库存数量
     * @param stockInitial 初始库存数量
     */
    public void setStockInitial(BigDecimal stockInitial) {
        this.stockInitial = stockInitial;
    }

    /**
     * 当前库存数量
     * @return stock_now 当前库存数量
     */
    public BigDecimal getStockNow() {
        return stockNow;
    }

    /**
     * 当前库存数量
     * @param stockNow 当前库存数量
     */
    public void setStockNow(BigDecimal stockNow) {
        this.stockNow = stockNow;
    }

    /**
     * 最低库存数量
     * @return stock_lowest 最低库存数量
     */
    public BigDecimal getStockLowest() {
        return stockLowest;
    }

    /**
     * 最低库存数量
     * @param stockLowest 最低库存数量
     */
    public void setStockLowest(BigDecimal stockLowest) {
        this.stockLowest = stockLowest;
    }

    /**
     * 零售价
     * @return retail_price 零售价
     */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    /**
     * 零售价
     * @param retailPrice 零售价
     */
    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 进货价
     * @return purchase_price 进货价
     */
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * 进货价
     * @param purchasePrice 进货价
     */
    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * 批发价
     * @return wholesale_price 批发价
     */
    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    /**
     * 批发价
     * @param wholesalePrice 批发价
     */
    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    /**
     * 库存标签（产品、原料、包装材料）
     * @return label 库存标签（产品、原料、包装材料）
     */
    public Integer getLabel() {
        return label;
    }

    /**
     * 库存标签（产品、原料、包装材料）
     * @param label 库存标签（产品、原料、包装材料）
     */
    public void setLabel(Integer label) {
        this.label = label;
    }

    /**
     * 介绍
     * @return introduction 介绍
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 介绍
     * @param introduction 介绍
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * 创建时间
     * @return creat_time 创建时间
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 创建时间
     * @param creatTime 创建时间
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 状态
     * @return state 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 状态
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}