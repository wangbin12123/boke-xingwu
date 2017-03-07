package cn.org.xingwu.controller;

import cn.org.xingwu.entity.Permission;
import cn.org.xingwu.service.IRolePermissionService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import cn.org.xingwu.entity.Permission;
import cn.org.xingwu.service.IPermissionService;
import cn.org.xingwu.service.IRolePermissionService;

/**
 * <p>
 * 角色管理相关操作
 * </p>
 *
 * @Author hubin
 * @Date 2016-04-15
 */
@Controller
@RequestMapping("/perm/permission")
public class PermissionController extends BaseController {

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IRolePermissionService rolePermissionService;

    @com.baomidou.kisso.annotation.Permission("2003")
    @RequestMapping("/list")
    public String list(Model model) {
        return "/permission/list";
    }

    @ResponseBody
    @com.baomidou.kisso.annotation.Permission("2003")
    @RequestMapping("/getPermissionList")
    public String getPermissionList() {
        Page<Permission> page = getPage();
        page.setOrderByField("pid");
        page.setAsc(true);
        return jsonPage(permissionService.selectPage(page, null));
    }

    @ResponseBody
    @com.baomidou.kisso.annotation.Permission("2003")
    @RequestMapping("/delete/{permId}")
    public String delete(@PathVariable Long permId) {
        boolean exist = rolePermissionService.existRolePermission(permId);
        if (exist) {
            return "false";
        }
        return booleanToString(permissionService.deleteById(permId));
    }

    /**
     * 添加系统菜单权限页面
     *
     * @return
     */
    @com.baomidou.kisso.annotation.Permission("2003")
    @RequestMapping("/add")
    public String addPermission() {
        return "/permission/save";
    }

    /**
     * 添加系统菜单权限实现
     *
     * @return
     */
    @com.baomidou.kisso.annotation.Permission("2003")
    @RequestMapping("/add/do")
    @ResponseBody
    public String savePermission(Permission permission) {
        boolean rlt = false;
        EntityWrapper<Permission> wrapper = new EntityWrapper<Permission>();
        Permission perm = new Permission();
        perm.setPid(0L);
        wrapper.setEntity(perm);
        Integer perTotal = permissionService.selectCount(wrapper);
        permission.setPid(0L);
        if (perTotal >= 1000) {
            permission.setPermCode(String.valueOf(perTotal));
        }
        if (perTotal < 1000) {
            permission.setPermCode(perTotal + "0");
        }
        if (perTotal < 100) {
            permission.setPermCode(perTotal + "00");
        }
        if (perTotal < 10) {
            permission.setPermCode(perTotal + "000");
        }
        permission.setState(0);
        permission.setType(0);
        permission.setSort(perTotal+1);
        permission.setId((perTotal+1)*1L);
        rlt = permissionService.insert(permission);
        if (!rlt) {
            callbackFail("权限添加失败！！！");
        }
        return callbackSuccess(rlt);
    }
}
