package com.jiaxin.shop.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class IncomeExpenses {
    /**
     * 
     */
    private Integer incomeExpensesId;

    /**
     * 当前余额
     */
    private BigDecimal balance;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行账号
     */
    private String accountNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 
     * @return income_expenses_id 
     */
    public Integer getIncomeExpensesId() {
        return incomeExpensesId;
    }

    /**
     * 
     * @param incomeExpensesId 
     */
    public void setIncomeExpensesId(Integer incomeExpensesId) {
        this.incomeExpensesId = incomeExpensesId;
    }

    /**
     * 当前余额
     * @return balance 当前余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 当前余额
     * @param balance 当前余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 银行名称
     * @return bank_name 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 银行名称
     * @param bankName 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 银行账号
     * @return account_num 银行账号
     */
    public String getAccountNum() {
        return accountNum;
    }

    /**
     * 银行账号
     * @param accountNum 银行账号
     */
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum == null ? null : accountNum.trim();
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
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}