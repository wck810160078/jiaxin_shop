package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.DictType;
import com.jiaxin.shop.utils.PageData;

import java.util.List;

public interface DictTypeMapper {
    /**
     *
     * @mbggenerated 2020-06-27
     */
    int deleteByPrimaryKey(Integer dictTypeId);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    int insert(DictType record);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    int insertSelective(DictType record);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    DictType selectByPrimaryKey(Integer dictTypeId);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    int updateByPrimaryKeySelective(DictType record);

    /**
     *
     * @mbggenerated 2020-06-27
     */
    int updateByPrimaryKey(DictType record);

    /**
     * 分页
     * @param pageData
     * @return
     */
    List<DictType> getDictTypeList(PageData<DictType> pageData);
    Long getDictTypeListCount(DictType paramObj);
}