package com.jiaxin.shop.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class StockRecord {
    /**
     * 库存记录id
     */
    private Integer stockRecordId;

    /**
     * 对应库存id
     */
    private Integer stockId;

    /**
     * 记录改变时间
     */
    private Date recordTime;

    /**
     * 旧库存记录
     */
    private BigDecimal stockNumOld;

    /**
     * 新库存记录
     */
    private BigDecimal stockNumNew;

    /**
     * 库存改变数量
     */
    private BigDecimal recordChange;

    /**
     * 库存记录id
     * @return stock_record_id 库存记录id
     */
    public Integer getStockRecordId() {
        return stockRecordId;
    }

    /**
     * 库存记录id
     * @param stockRecordId 库存记录id
     */
    public void setStockRecordId(Integer stockRecordId) {
        this.stockRecordId = stockRecordId;
    }

    /**
     * 对应库存id
     * @return stock_id 对应库存id
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * 对应库存id
     * @param stockId 对应库存id
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * 记录改变时间
     * @return record_time 记录改变时间
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     * 记录改变时间
     * @param recordTime 记录改变时间
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * 旧库存记录
     * @return stock_num_old 旧库存记录
     */
    public BigDecimal getStockNumOld() {
        return stockNumOld;
    }

    /**
     * 旧库存记录
     * @param stockNumOld 旧库存记录
     */
    public void setStockNumOld(BigDecimal stockNumOld) {
        this.stockNumOld = stockNumOld;
    }

    /**
     * 新库存记录
     * @return stock_num_new 新库存记录
     */
    public BigDecimal getStockNumNew() {
        return stockNumNew;
    }

    /**
     * 新库存记录
     * @param stockNumNew 新库存记录
     */
    public void setStockNumNew(BigDecimal stockNumNew) {
        this.stockNumNew = stockNumNew;
    }

    /**
     * 库存改变数量
     * @return record_change 库存改变数量
     */
    public BigDecimal getRecordChange() {
        return recordChange;
    }

    /**
     * 库存改变数量
     * @param recordChange 库存改变数量
     */
    public void setRecordChange(BigDecimal recordChange) {
        this.recordChange = recordChange;
    }
}