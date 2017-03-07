package cn.org.xingwu.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import cn.org.xingwu.entity.RolePermission;

/**
 *
 * RolePermission 表数据库控制层接口
 *
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

	
	/**
	 * 根据角色ID获取对应的所有关联权限的ID
	 * @param id 角色Id
	 * @return
	 */
	List<Long> selecPermissionIdsByRoleId(Long id);


}