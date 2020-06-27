package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.DictInfo;
import com.jiaxin.shop.pojo.DictType;
import com.jiaxin.shop.service.DictService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DictController {

    @Resource
    private DictService dictService;

    /**
     * 新增/修改 字典类型
     * @param dictType
     * @return
     */
    @PostMapping("/staff/saveDictType")
    public Msg saveDictType(@RequestBody DictType dictType){
        if(BaseUtil.isBlank(dictType.getDictName(),dictType.getDictCode())){
            return Msg.fail("缺少关键参数");
        }
        return dictService.saveDictType(dictType);
    }


    /**
     * 新增/修改 字典内容
     * @param dictInfo
     * @return
     */
    @PostMapping("/staff/saveDictInfo")
    public Msg saveDictInfo(@RequestBody DictInfo dictInfo){
        if(BaseUtil.isBlank(dictInfo.getDictInfo(),dictInfo.getDictTypeId())){
            return Msg.fail("缺少关键参数");
        }
        return dictService.saveDictInfo(dictInfo);
    }

    /**
     * 删除字典内容
     * @param distInfoId
     * @return
     */
    @GetMapping("/staff/deleteDictInfo")
    public Msg deleteDictInfo(Integer distInfoId){
        return dictService.deleteDictInfo(distInfoId);
    }


    /**
     * 删除字典类型
     * @param distTypeId
     * @return
     */
    @GetMapping("/staff/deleteDictType")
    public Msg deleteDictType(Integer distTypeId){
        return dictService.deleteDictType(distTypeId);
    }


    /**
     * 字典类型列表分页
     * @param pageData
     * @return
     */
    @PostMapping("/staff/getDictTypeList")
    public Msg getDictTypeList(@RequestBody PageData<DictType> pageData){
        if(pageData.getParamObj()==null){
            pageData.setParamObj(new DictType());
        }
        return dictService.getDictTypeList(pageData);
    }

    /**
     * 字典列表分页
     * @param pageData
     * @return
     */
    @PostMapping("/staff/getDictInfoList")
    public Msg getDictInfoList(@RequestBody PageData<DictInfo> pageData){
        if(pageData.getParamObj()==null){
            pageData.setParamObj(new DictInfo());
        }
        return dictService.getDictInfoList(pageData);
    }
}
