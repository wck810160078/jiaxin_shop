package com.jiaxin.shop.service.impl;

import com.jiaxin.shop.dao.DictInfoMapper;
import com.jiaxin.shop.dao.DictTypeMapper;
import com.jiaxin.shop.pojo.DictInfo;
import com.jiaxin.shop.pojo.DictType;
import com.jiaxin.shop.pojo.IncomeExpenses;
import com.jiaxin.shop.service.DictService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DictServiceImpl implements DictService {

    @Resource
    private DictInfoMapper dictInfoMapper;
    @Resource
    private DictTypeMapper dictTypeMapper;

    @Override
    public Msg saveDictType(DictType dictType) {
        Date date = new Date();
        dictType.setUpdateTime(date);
        if(BaseUtil.isBlank(dictType.getDictTypeId())){
            dictType.setCreateTime(date);
            return dictTypeMapper.insertSelective(dictType)==0?Msg.fail("新增字典类型失败"):Msg.success("新增字典类型成功");
        }
        return dictTypeMapper.updateByPrimaryKeySelective(dictType)==0?Msg.fail("修改字典类型失败"):Msg.success("修改字典类型成功");
    }

    @Override
    public Msg saveDictInfo(DictInfo dictInfo) {
        Date date = new Date();
        dictInfo.setUpdateTime(date);
        if(BaseUtil.isBlank(dictInfo.getDictInfoId())){
            dictInfo.setCreatTime(date);
            return dictInfoMapper.insertSelective(dictInfo)==0?Msg.fail("新增字典失败"):Msg.success("新增字典成功");
        }
        return dictInfoMapper.updateByPrimaryKeySelective(dictInfo)==0?Msg.fail("修改字典失败"):Msg.success("修改字典成功");
    }

    @Override
    public Msg deleteDictInfo(Integer distInfoId) {
        return dictInfoMapper.deleteByPrimaryKey(distInfoId)==0?Msg.fail("删除失败"):Msg.success("删除成功");
    }

    @Override
    public Msg deleteDictType(Integer distTypeId) {
        DictInfo dictInfo = dictInfoMapper.getInfoByType(distTypeId);
        if(dictInfo!=null){
            return Msg.fail("删除失败，该类型下存在字典信息");
        }
        return dictTypeMapper.deleteByPrimaryKey(distTypeId)==0?Msg.fail("删除失败"):Msg.success("删除成功");
    }

    @Override
    public Msg getDictTypeList(PageData<DictType> pageData) {
        if(pageData.getPage()!=null&&pageData.getSize()!=null){
            pageData.setPageIndex((pageData.getPage()-1)*pageData.getSize());
        }

        List<DictType> dictTypeList = dictTypeMapper.getDictTypeList(pageData);
        Long count = dictTypeMapper.getDictTypeListCount(pageData.getParamObj());

        pageData.setRows(dictTypeList);
        pageData.setTotal(count);
        return Msg.success().setResp(pageData);
    }

    @Override
    public Msg getDictInfoList(PageData<DictInfo> pageData) {
        if(pageData.getPage()!=null&&pageData.getSize()!=null){
            pageData.setPageIndex((pageData.getPage()-1)*pageData.getSize());
        }

        List<DictInfo> dictInfoList = dictInfoMapper.getDictInfoList(pageData);
        Long count = dictInfoMapper.getDictInfoListCount(pageData.getParamObj());

        pageData.setRows(dictInfoList);
        pageData.setTotal(count);
        return Msg.success().setResp(pageData);
    }
}
