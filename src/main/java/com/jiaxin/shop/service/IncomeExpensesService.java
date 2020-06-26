package com.jiaxin.shop.service;

import com.jiaxin.shop.pojo.IncomeExpenses;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;

public interface IncomeExpensesService {
    Msg saveIncomeExpenses(IncomeExpenses incomeExpenses);

    Msg deleteIncomeExpenses(Integer incomeExpensesId);

    Msg getIncomeExpensesList(PageData<IncomeExpenses> pageData);
}
