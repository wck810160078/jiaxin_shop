package com.jiaxin.shop.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class StockRecord {
    /**
     * 当日生产/消耗记录id
     */
    private Integer stockRecordId;

    /**
     * 库存id
     */
    private Integer stockId;

    /**
     * 当日日期
     */
    private Date thatDay;

    /**
     * 生产/消耗前的数量
     */
    private BigDecimal oldNumber;

    /**
     * 生产/消耗的数量
     */
    private BigDecimal number;

    /**
     * 生产/消耗后的数量
     */
    private BigDecimal newNumber;

    /**
     * 标签（生产/消耗）
     */
    private Integer label;

    /**
     * 创建日期
     */
    private Date creatTime;

    /**
     * 修改日期
     */
    private Date updateTime;

    /**
     * 创建人id
     */
    private Integer staffId;

    //以下为自定义字段

    /**
     * 查询起始日期
     */
    private Date beginDate ;

    /**
     * 查询终止日期
     */
    private Date endDate ;

    /**
     * 库存信息名称规格
     */
    private String stockName ;

    /**
     * 记录添加者姓名
     */
    private String staffName ;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 当日生产/消耗记录id
     * @return stock_record_id 当日生产/消耗记录id
     */
    public Integer getStockRecordId() {
        return stockRecordId;
    }

    /**
     * 当日生产/消耗记录id
     * @param stockRecordId 当日生产/消耗记录id
     */
    public void setStockRecordId(Integer stockRecordId) {
        this.stockRecordId = stockRecordId;
    }

    /**
     * 库存id
     * @return stock_id 库存id
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * 库存id
     * @param stockId 库存id
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * 当日日期
     * @return that_day 当日日期
     */
    public Date getThatDay() {
        return thatDay;
    }

    /**
     * 当日日期
     * @param thatDay 当日日期
     */
    public void setThatDay(Date thatDay) {
        this.thatDay = thatDay;
    }

    /**
     * 生产/消耗前的数量
     * @return old_number 生产/消耗前的数量
     */
    public BigDecimal getOldNumber() {
        return oldNumber;
    }

    /**
     * 生产/消耗前的数量
     * @param oldNumber 生产/消耗前的数量
     */
    public void setOldNumber(BigDecimal oldNumber) {
        this.oldNumber = oldNumber;
    }

    /**
     * 生产/消耗的数量
     * @return number 生产/消耗的数量
     */
    public BigDecimal getNumber() {
        return number;
    }

    /**
     * 生产/消耗的数量
     * @param number 生产/消耗的数量
     */
    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    /**
     * 生产/消耗后的数量
     * @return new_number 生产/消耗后的数量
     */
    public BigDecimal getNewNumber() {
        return newNumber;
    }

    /**
     * 生产/消耗后的数量
     * @param newNumber 生产/消耗后的数量
     */
    public void setNewNumber(BigDecimal newNumber) {
        this.newNumber = newNumber;
    }

    /**
     * 标签（生产/消耗）
     * @return label 标签（生产/消耗）
     */
    public Integer getLabel() {
        return label;
    }

    /**
     * 标签（生产/消耗）
     * @param label 标签（生产/消耗）
     */
    public void setLabel(Integer label) {
        this.label = label;
    }

    /**
     * 创建日期
     * @return creat_time 创建日期
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 创建日期
     * @param creatTime 创建日期
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * 修改日期
     * @return update_time 修改日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改日期
     * @param updateTime 修改日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建人id
     * @return staff_id 创建人id
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * 创建人id
     * @param staffId 创建人id
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}