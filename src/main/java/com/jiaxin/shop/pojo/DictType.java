package com.jiaxin.shop.pojo;

import java.util.Date;

public class DictType {
    /**
     * 数据字典类型id
     */
    private Integer dictTypeId;

    /**
     * 数据字典类型编码
     */
    private String dictCode;

    /**
     * 数据字典类型名称
     */
    private String dictName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态
     */
    private String state;

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
     * 数据字典类型编码
     * @return dict_code 数据字典类型编码
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * 数据字典类型编码
     * @param dictCode 数据字典类型编码
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    /**
     * 数据字典类型名称
     * @return dict_name 数据字典类型名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 数据字典类型名称
     * @param dictName 数据字典类型名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
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

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
}