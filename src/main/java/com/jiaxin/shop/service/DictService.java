package com.jiaxin.shop.service;

import com.jiaxin.shop.pojo.DictInfo;
import com.jiaxin.shop.pojo.DictType;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;

public interface DictService {
    /**
     * 新增/修改 字典类型
     * @param dictType
     * @return
     */
    Msg saveDictType(DictType dictType);

    /**
     * 新增/修改 字典内容
     * @param dictInfo
     * @return
     */
    Msg saveDictInfo(DictInfo dictInfo);

    /**
     * 删除字典内容
     * @param distInfoId
     * @return
     */
    Msg deleteDictInfo(Integer distInfoId);

    /**
     * 删除字典类型
     * @param distTypeId
     * @return
     */
    Msg deleteDictType(Integer distTypeId);

    /**
     * 字典类型列表分页
     * @param pageData
     * @return
     */
    Msg getDictTypeList(PageData<DictType> pageData);

    /**
     * 字典列表分页
     * @param pageData
     * @return
     */
    Msg getDictInfoList(PageData<DictInfo> pageData);
}
