package com.jiaxin.shop.pojo;

public class District {
    /**
     * 主键自增
     */
    private Integer id;

    /**
     * 父类id
     */
    private Integer pid;

    /**
     * 城市的名字
     */
    private String districtName;

    /**
     * 城市的类型，0是国，1是省，2是市，3是区
     */
    private Integer type;

    /**
     * 地区所处的层级
     */
    private Integer hierarchy;

    /**
     * 层级序列
     */
    private String districtSqe;

    /**
     * 主键自增
     * @return id 主键自增
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键自增
     * @param id 主键自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 父类id
     * @return pid 父类id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 父类id
     * @param pid 父类id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 城市的名字
     * @return district_name 城市的名字
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * 城市的名字
     * @param districtName 城市的名字
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    /**
     * 城市的类型，0是国，1是省，2是市，3是区
     * @return type 城市的类型，0是国，1是省，2是市，3是区
     */
    public Integer getType() {
        return type;
    }

    /**
     * 城市的类型，0是国，1是省，2是市，3是区
     * @param type 城市的类型，0是国，1是省，2是市，3是区
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 地区所处的层级
     * @return hierarchy 地区所处的层级
     */
    public Integer getHierarchy() {
        return hierarchy;
    }

    /**
     * 地区所处的层级
     * @param hierarchy 地区所处的层级
     */
    public void setHierarchy(Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    /**
     * 层级序列
     * @return district_sqe 层级序列
     */
    public String getDistrictSqe() {
        return districtSqe;
    }

    /**
     * 层级序列
     * @param districtSqe 层级序列
     */
    public void setDistrictSqe(String districtSqe) {
        this.districtSqe = districtSqe == null ? null : districtSqe.trim();
    }
}