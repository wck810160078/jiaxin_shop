package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.IncomeExpenses;
import com.jiaxin.shop.utils.PageData;

import java.util.List;

public interface IncomeExpensesMapper {
    /**
     *
     * @mbggenerated 2020-06-26
     */
    int deleteByPrimaryKey(Integer incomeExpensesId);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int insert(IncomeExpenses record);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int insertSelective(IncomeExpenses record);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    IncomeExpenses selectByPrimaryKey(Integer incomeExpensesId);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int updateByPrimaryKeySelective(IncomeExpenses record);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int updateByPrimaryKey(IncomeExpenses record);

    /**
     * 分页列表
     * @param pageData
     * @return
     */
    List<IncomeExpenses> getIncomeExpensesList(PageData<IncomeExpenses> pageData);
    Long getIncomeExpensesListCount(IncomeExpenses paramObj);
}