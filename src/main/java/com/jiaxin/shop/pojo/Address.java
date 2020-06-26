package com.jiaxin.shop.pojo;

public class Address {
    /**
     * 地址id（主键）
     */
    private Integer addressId;

    /**
     * 地区id
     */
    private Integer districtId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 地址id（主键）
     * @return address_id 地址id（主键）
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * 地址id（主键）
     * @param addressId 地址id（主键）
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * 地区id
     * @return district_id 地区id
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * 地区id
     * @param districtId 地区id
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 手机号码
     * @return phone_number 手机号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 手机号码
     * @param phoneNumber 手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 详细地址
     * @return address_detail 详细地址
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * 详细地址
     * @param addressDetail 详细地址
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }
}