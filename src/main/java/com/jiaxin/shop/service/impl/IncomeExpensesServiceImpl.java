package com.jiaxin.shop.service.impl;

import com.jiaxin.shop.dao.IncomeExpensesMapper;
import com.jiaxin.shop.pojo.IncomeExpenses;
import com.jiaxin.shop.service.IncomeExpensesService;
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
public class IncomeExpensesServiceImpl implements IncomeExpensesService {

    @Resource
    private IncomeExpensesMapper incomeExpensesMapper;

    @Override
    public Msg saveIncomeExpenses(IncomeExpenses incomeExpenses) {
        Date date = new Date();
        incomeExpenses.setUpdateTime(date);
        if(BaseUtil.isBlank(incomeExpenses.getIncomeExpensesId())){
            incomeExpenses.setCreateTime(date);
            return incomeExpensesMapper.insertSelective(incomeExpenses)==0?Msg.fail("新增失败"):Msg.success("新增成功");
        }
        return incomeExpensesMapper.updateByPrimaryKeySelective(incomeExpenses)==0?Msg.fail("修改失败"):Msg.success("修改成功");
    }

    @Override
    public Msg deleteIncomeExpenses(Integer incomeExpensesId) {
        return incomeExpensesMapper.deleteByPrimaryKey(incomeExpensesId)==0?Msg.fail("删除失败"):Msg.success("删除成功");
    }

    @Override
    public Msg getIncomeExpensesList(PageData<IncomeExpenses> pageData) {
        if(pageData.getPage()!=null&&pageData.getSize()!=null){
            pageData.setPageIndex((pageData.getPage()-1)*pageData.getSize());
        }

        List<IncomeExpenses> incomeExpensesList = incomeExpensesMapper.getIncomeExpensesList(pageData);
        Long count = incomeExpensesMapper.getIncomeExpensesListCount(pageData.getParamObj());

        pageData.setRows(incomeExpensesList);
        pageData.setTotal(count);
        return Msg.success().setResp(pageData);
    }
}
