package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.DictInfo;
import com.jiaxin.shop.utils.PageData;

import java.util.List;

public interface DictInfoMapper {
    /**
     *
     * @mbggenerated 2020-06-27
     */
    int deleteByPrimaryKey(Integer dictInfoId);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    int insert(DictInfo record);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    int insertSelective(DictInfo record);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    DictInfo selectByPrimaryKey(Integer dictInfoId);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    int updateByPrimaryKeySelective(DictInfo record);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    int updateByPrimaryKey(DictInfo record);

    /**
     * 通过类型id查内容
     * @param distTypeId
     * @return
     */
    DictInfo getInfoByType(Integer distTypeId);

    /**
     * 分页
     * @param pageData
     * @return
     */
    List<DictInfo> getDictInfoList(PageData<DictInfo> pageData);
    Long getDictInfoListCount(DictInfo paramObj);
}