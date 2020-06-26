package com.jiaxin.shop.dao;

import com.jiaxin.shop.pojo.Address;

public interface AddressMapper {
    /**
     *
     * @mbggenerated 2020-06-26
     */
    int deleteByPrimaryKey(Integer addressId);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int insert(Address record);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int insertSelective(Address record);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    Address selectByPrimaryKey(Integer addressId);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int updateByPrimaryKeySelective(Address record);

    /**
     *
     * @mbggenerated 2020-06-26
     */
    int updateByPrimaryKey(Address record);
}