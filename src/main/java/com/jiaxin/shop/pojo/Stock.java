package com.jiaxin.shop.pojo;

import java.util.Date;

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
    private Integer stockInitial;

    /**
     * 当前库存数量
     */
    private Integer stockNow;

    /**
     * 最低库存数量
     */
    private Integer stockLowest;

    /**
     * 零售价
     */
    private Double retailPrice;

    /**
     * 进货价
     */
    private Double purchasePrice;

    /**
     * 批发价
     */
    private Double wholesalePrice;

    /**
     * 库存标签（产品、原料、包装材料）
     */
    private String label;

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
    private String stockSearchContent ;

    public String getStockSearchContent() {
        return stockSearchContent;
    }

    public void setStockSearchContent(String stockSearchContent) {
        this.stockSearchContent = stockSearchContent;
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
    public Integer getStockInitial() {
        return stockInitial;
    }

    /**
     * 初始库存数量
     * @param stockInitial 初始库存数量
     */
    public void setStockInitial(Integer stockInitial) {
        this.stockInitial = stockInitial;
    }

    /**
     * 当前库存数量
     * @return stock_now 当前库存数量
     */
    public Integer getStockNow() {
        return stockNow;
    }

    /**
     * 当前库存数量
     * @param stockNow 当前库存数量
     */
    public void setStockNow(Integer stockNow) {
        this.stockNow = stockNow;
    }

    /**
     * 最低库存数量
     * @return stock_lowest 最低库存数量
     */
    public Integer getStockLowest() {
        return stockLowest;
    }

    /**
     * 最低库存数量
     * @param stockLowest 最低库存数量
     */
    public void setStockLowest(Integer stockLowest) {
        this.stockLowest = stockLowest;
    }

    /**
     * 零售价
     * @return retail_price 零售价
     */
    public Double getRetailPrice() {
        return retailPrice;
    }

    /**
     * 零售价
     * @param retailPrice 零售价
     */
    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 进货价
     * @return purchase_price 进货价
     */
    public Double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * 进货价
     * @param purchasePrice 进货价
     */
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * 批发价
     * @return wholesale_price 批发价
     */
    public Double getWholesalePrice() {
        return wholesalePrice;
    }

    /**
     * 批发价
     * @param wholesalePrice 批发价
     */
    public void setWholesalePrice(Double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    /**
     * 库存标签（产品、原料、包装材料）
     * @return label 库存标签（产品、原料、包装材料）
     */
    public String getLabel() {
        return label;
    }

    /**
     * 库存标签（产品、原料、包装材料）
     * @param label 库存标签（产品、原料、包装材料）
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
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

    public Stock(String stockName, String stockType, String unit, String supplier, Integer stockInitial, Integer stockNow, Integer stockLowest, Double retailPrice, Double purchasePrice, Double wholesalePrice, String label, String introduction,String state, String remark) {
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

//    public Stock(Integer stockId, String stockName, String stockType, String unit, String supplier, Integer stockInitial, Integer stockNow, Integer stockLowest, Double retailPrice, Double purchasePrice, Double wholesalePrice, String label, String introduction, Date creatTime, Date updateTime, String state, String remark) {
//        this.stockId = stockId;
//        this.stockName = stockName;
//        this.stockType = stockType;
//        this.unit = unit;
//        this.supplier = supplier;
//        this.stockInitial = stockInitial;
//        this.stockNow = stockNow;
//        this.stockLowest = stockLowest;
//        this.retailPrice = retailPrice;
//        this.purchasePrice = purchasePrice;
//        this.wholesalePrice = wholesalePrice;
//        this.label = label;
//        this.introduction = introduction;
//        this.creatTime = creatTime;
//        this.updateTime = updateTime;
//        this.state = state;
//        this.remark = remark;
//    }

    public Stock() {
    }
}