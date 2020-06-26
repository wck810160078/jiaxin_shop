package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.IncomeExpenses;
import com.jiaxin.shop.service.IncomeExpensesService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IncomeExpensesController {

    @Resource
    private IncomeExpensesService incomeExpensesService;

    /**
     * 新增/修改 收支账户
     * @param incomeExpenses
     * @return
     */
    @PostMapping("/staff/saveIncomeExpenses")
    public Msg saveIncomeExpenses(@RequestBody IncomeExpenses incomeExpenses){
        if(BaseUtil.isBlank(incomeExpenses.getAccountNum(),incomeExpenses.getBalance(),incomeExpenses.getBankName())){
            return Msg.fail("缺少关键参数");
        }
        return incomeExpensesService.saveIncomeExpenses(incomeExpenses);
    }

    /**
     * 删除收支账户
     * @param incomeExpensesId
     * @return
     */
    @GetMapping("/staff/deleteIncomeExpenses")
    public Msg deleteIncomeExpenses(Integer incomeExpensesId){
        return incomeExpensesService.deleteIncomeExpenses(incomeExpensesId);
    }

    /**
     * 收支账户列表
     * @param pageData
     * @return
     */
    @PostMapping("/staff/getIncomeExpensesList")
    public Msg getIncomeExpensesList(@RequestBody PageData<IncomeExpenses> pageData){
        if(pageData.getParamObj()==null){
            pageData.setParamObj(new IncomeExpenses());
        }
        return incomeExpensesService.getIncomeExpensesList(pageData);
    }
}
