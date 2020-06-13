package com.jiaxin.shop.service;

import com.jiaxin.shop.dao.SysPermissionMapper;
import com.jiaxin.shop.pojo.SysPermission;
import com.jiaxin.shop.utils.BaseUtil;
import com.jiaxin.shop.utils.ExcelUtil;
import com.jiaxin.shop.utils.Msg;
import com.jiaxin.shop.utils.PageData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    public List<SysPermission> selectListByUser(Integer id) {
        List<SysPermission> sysPermissionList = sysPermissionMapper.selectListByUser(id);
        return sysPermissionList;
    }

    public List<SysPermission> selectListByPath(String requestUrl) {
        return sysPermissionMapper.selectListByPath(requestUrl);
    }

    /**
     * @Author chenting
     * @Description  新增/修改权限信息 
     * @Date 10:24 2020/6/13
     * @Param [sysPermission]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg saveSysPermission(SysPermission sysPermission) {
        if(BaseUtil.isBlank(sysPermission.getId())) {
            return sysPermissionMapper.insertSelective(sysPermission) == 0 ? Msg.fail("新增权限信息失败") : Msg.success("新增权限信息成功") ;
        }
        return sysPermissionMapper.updateByPrimaryKeySelective(sysPermission) == 0 ? Msg.fail("修改权限信息失败") : Msg.success("修改权限信息成功") ;
    }

    /**
     * @Author chenting
     * @Description  导入权限信息 
     * @Date 11:14 2020/6/13
     * @Param [excelFile]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg importSysPermission(MultipartFile excelFile) throws IOException {

        //初始化workbook
        Workbook workbook = ExcelUtil.initExcel(excelFile);

        Sheet sheet = workbook.getSheetAt(0) ;
        int totalRowNum = sheet.getLastRowNum() ;

        //从表格获取到的数据
        //权限编码
        String permissionCode = null;
        //权限名称
        String permissionName = null;
        //上一级id
        Integer parentId = null;

        for(int i = 4 ; i < totalRowNum ; i++) {
            //获取第i行的数据
            Row row = sheet.getRow(i);
            Cell permissionCodeCell = row.getCell(0) ;
            if(permissionCodeCell != null && permissionCodeCell.getCellType() == Cell.CELL_TYPE_STRING) {
                permissionCode = permissionCodeCell.getStringCellValue() ;
            }
            Cell permissionNameCell = row.getCell(1) ;
            if(permissionNameCell != null && permissionNameCell.getCellType() == Cell.CELL_TYPE_STRING) {
                permissionName = permissionNameCell.getStringCellValue() ;
            }
            Cell parentIdCell = row.getCell(2) ;
            if(parentIdCell != null && parentIdCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                parentId = (int) parentIdCell.getNumericCellValue() ;
            }

            //填充数据
            SysPermission sysPermission = new SysPermission() ;
            sysPermission.setPermissionCode(permissionCode);
            sysPermission.setPermissionName(permissionName);
            sysPermission.setParentId(parentId);

            sysPermissionMapper.insertSelective(sysPermission);
        }
        return Msg.success("导入权限信息成功") ;
    }


    /**
     * @Author chenting
     * @Description  获取权限信息列表
     * @Date 12:31 2020/6/13
     * @Param [sysPermissionPageData]
     * @return com.jiaxin.shop.utils.Msg
     **/
    public Msg getSysPermissionList(Integer parentId) {
        List<SysPermission> sysPermissionList = sysPermissionMapper.getSysPermissionList(parentId) ;
//        Long count = sysPermissionMapper.getSysPermissionCount(parentId) ;
        
        return Msg.success().setResp(sysPermissionList) ;
    }
}
