package com.jiaxin.shop.pojo;

public class StockImg {
    /**
     * 图片id
     */
    private Integer stockImgId;

    /**
     * 图片名称
     */
    private String stockImgSrc;

    /**
     * 所属库存id
     */
    private Integer stockId;

    /**
     * 状态
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 图片id
     * @return stock_img_id 图片id
     */
    public Integer getStockImgId() {
        return stockImgId;
    }

    /**
     * 图片id
     * @param stockImgId 图片id
     */
    public void setStockImgId(Integer stockImgId) {
        this.stockImgId = stockImgId;
    }

    /**
     * 图片名称
     * @return stock_img_src 图片名称
     */
    public String getStockImgSrc() {
        return stockImgSrc;
    }

    /**
     * 图片名称
     * @param stockImgSrc 图片名称
     */
    public void setStockImgSrc(String stockImgSrc) {
        this.stockImgSrc = stockImgSrc == null ? null : stockImgSrc.trim();
    }

    /**
     * 所属库存id
     * @return stock_id 所属库存id
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * 所属库存id
     * @param stockId 所属库存id
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
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