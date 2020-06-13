package com.jiaxin.shop.controller;

import com.jiaxin.shop.pojo.SysPermission;
import com.jiaxin.shop.service.SysPermissionService;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class SysPermissionController {

    @Resource
    private SysPermissionService sysPermissionService ;

    /**
     * @Author chenting
     * @Description  新增/修改权限信息 
     * @Date 10:22 2020/6/13
     * @Param [sysPermission]
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/admin/saveSysPermission")
    public Msg saveSysPermission(@RequestBody SysPermission sysPermission) {
        if(BaseUtil.isBlank(sysPermission.getPermissionCode(),sysPermission.getPermissionName())) {
            return Msg.fail("新增权限失败，权限编码/权限名称不能为空") ;
        }
        return sysPermissionService.saveSysPermission(sysPermission) ;
    }

    /**
     * @Author chenting
     * @Description  导入权限信息
     * @Date 10:47 2020/6/13
     * @Param [excelFile]   excel文件
     * @return com.jiaxin.shop.utils.Msg
     **/
    @PostMapping("/admin/importSysPermission")
    public Msg importSysPermission(@RequestParam MultipartFile excelFile) throws IOException {
        return sysPermissionService.importSysPermission(excelFile) ;
    }

    /**
     * @Author chenting
     * @Description  获取所有全新信息列表
     * @Date 12:12 2020/6/13
     * @Param []
     * @return com.jiaxin.shop.utils.Msg
     **/
    @GetMapping("/admin/getSysPermissionList")
    public Msg getSysPermissionList(Integer parentId) {
        return sysPermissionService.getSysPermissionList(parentId) ;
    }
}
