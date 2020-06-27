package com.jiaxin.shop.pojo;

import java.util.Date;

public class DictInfo {
    /**
     * 数据字典明细id
     */
    private Integer dictInfoId;

    /**
     * 数据字典类型id
     */
    private Integer dictTypeId;

    /**
     * 数据字典明细内容
     */
    private String dictInfo;

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

    //自定义字段
    private String dictCode;

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    /**
     * 数据字典明细id
     * @return dict_info_id 数据字典明细id
     */
    public Integer getDictInfoId() {
        return dictInfoId;
    }

    /**
     * 数据字典明细id
     * @param dictInfoId 数据字典明细id
     */
    public void setDictInfoId(Integer dictInfoId) {
        this.dictInfoId = dictInfoId;
    }

    /**
     * 数据字典类型id
     * @return dict_type_id 数据字典类型id
     */
    public Integer getDictTypeId() {
        return dictTypeId;
    }

    /**
     * 数据字典类型id
     * @param dictTypeId 数据字典类型id
     */
    public void setDictTypeId(Integer dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    /**
     * 数据字典明细内容
     * @return dict_info 数据字典明细内容
     */
    public String getDictInfo() {
        return dictInfo;
    }

    /**
     * 数据字典明细内容
     * @param dictInfo 数据字典明细内容
     */
    public void setDictInfo(String dictInfo) {
        this.dictInfo = dictInfo == null ? null : dictInfo.trim();
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