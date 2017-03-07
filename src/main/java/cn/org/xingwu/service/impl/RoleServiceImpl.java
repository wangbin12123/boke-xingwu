package cn.org.xingwu.service.impl;

import cn.org.xingwu.entity.UserRole;
import cn.org.xingwu.mapper.UserRoleMapper;
import cn.org.xingwu.service.IRoleService;
import cn.org.xingwu.service.support.BaseServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import cn.org.xingwu.entity.Role;
import cn.org.xingwu.entity.UserRole;
import cn.org.xingwu.mapper.RoleMapper;
import cn.org.xingwu.mapper.UserRoleMapper;
import cn.org.xingwu.service.IRoleService;
import cn.org.xingwu.service.support.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Role 表数据服务层接口实现类
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements IRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public void deleteByUserId(Long userId) {
		UserRole ur = new UserRole();
		ur.setUid(userId);
		userRoleMapper.delete(new EntityWrapper<UserRole>(ur));
	}

}
