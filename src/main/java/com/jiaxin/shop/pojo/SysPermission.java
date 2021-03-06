package com.jiaxin.shop.pojo;

public class SysPermission {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 权限code
     */
    private String permissionCode;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 上一级id
     */
    private Integer parentId;

    /**
     * 主键id
     * @return id 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 权限code
     * @return permission_code 权限code
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * 权限code
     * @param permissionCode 权限code
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * 权限名
     * @return permission_name 权限名
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 权限名
     * @param permissionName 权限名
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 上一级id
     * @return parent_id 上一级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 上一级id
     * @param parentId 上一级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}