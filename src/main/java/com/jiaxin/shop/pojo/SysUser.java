package com.jiaxin.shop.pojo;

import java.util.Date;

public class SysUser {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 上一次登录时间
     */
    private Date lastLoginTime;

    /**
     * 账号是否可用。默认为1（可用）
     */
    private Boolean enabled;

    /**
     * 是否过期。默认为1（没有过期）
     */
    private Boolean notExpired;

    /**
     * 账号是否锁定。默认为1（没有锁定）
     */
    private Boolean accountNotLocked;

    /**
     * 证书（密码）是否过期。默认为1（没有过期）
     */
    private Boolean credentialsNotExpired;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 修改人
     */
    private Integer updateUser;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 用户密码
     * @return password 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 真实姓名
     * @return name 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 真实姓名
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 手机号
     * @return phone_number 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 手机号
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 上一次登录时间
     * @return last_login_time 上一次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 上一次登录时间
     * @param lastLoginTime 上一次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 账号是否可用。默认为1（可用）
     * @return enabled 账号是否可用。默认为1（可用）
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 账号是否可用。默认为1（可用）
     * @param enabled 账号是否可用。默认为1（可用）
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 是否过期。默认为1（没有过期）
     * @return not_expired 是否过期。默认为1（没有过期）
     */
    public Boolean getNotExpired() {
        return notExpired;
    }

    /**
     * 是否过期。默认为1（没有过期）
     * @param notExpired 是否过期。默认为1（没有过期）
     */
    public void setNotExpired(Boolean notExpired) {
        this.notExpired = notExpired;
    }

    /**
     * 账号是否锁定。默认为1（没有锁定）
     * @return account_not_locked 账号是否锁定。默认为1（没有锁定）
     */
    public Boolean getAccountNotLocked() {
        return accountNotLocked;
    }

    /**
     * 账号是否锁定。默认为1（没有锁定）
     * @param accountNotLocked 账号是否锁定。默认为1（没有锁定）
     */
    public void setAccountNotLocked(Boolean accountNotLocked) {
        this.accountNotLocked = accountNotLocked;
    }

    /**
     * 证书（密码）是否过期。默认为1（没有过期）
     * @return credentials_not_expired 证书（密码）是否过期。默认为1（没有过期）
     */
    public Boolean getCredentialsNotExpired() {
        return credentialsNotExpired;
    }

    /**
     * 证书（密码）是否过期。默认为1（没有过期）
     * @param credentialsNotExpired 证书（密码）是否过期。默认为1（没有过期）
     */
    public void setCredentialsNotExpired(Boolean credentialsNotExpired) {
        this.credentialsNotExpired = credentialsNotExpired;
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
     * 创建人
     * @return create_user 创建人
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     * @param createUser 创建人
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 修改人
     * @return update_user 修改人
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     * @param updateUser 修改人
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 登录ip
     * @return login_ip 登录ip
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 登录ip
     * @param loginIp 登录ip
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }
}