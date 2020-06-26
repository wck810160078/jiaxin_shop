package com.jiaxin.shop.service;

import com.jiaxin.shop.pojo.SysPermission;
import com.jiaxin.shop.utils.Msg;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SysPermissionService {

    List<SysPermission> selectListByUser(Integer id);

    List<SysPermission> selectListByPath(String requestUrl);

    /**
     * @Author chenting
     * @Description  新增/修改权限信息 
     * @Date 10:24 2020/6/13
     * @Param [sysPermission]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg saveSysPermission(SysPermission sysPermission);

    /**
     * @Author chenting
     * @Description  导入权限信息 
     * @Date 11:14 2020/6/13
     * @Param [excelFile]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg importSysPermission(MultipartFile excelFile) throws IOException;


    /**
     * @Author chenting
     * @Description  获取权限信息列表
     * @Date 12:31 2020/6/13
     * @Param [sysPermissionPageData]
     * @return com.jiaxin.shop.utils.Msg
     **/
    Msg getSysPermissionList(Integer parentId);
}
