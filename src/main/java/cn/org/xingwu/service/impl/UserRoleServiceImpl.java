package cn.org.xingwu.service.impl;

import cn.org.xingwu.service.IUserRoleService;
import cn.org.xingwu.service.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import cn.org.xingwu.entity.UserRole;
import cn.org.xingwu.mapper.UserRoleMapper;
import cn.org.xingwu.service.IUserRoleService;
import cn.org.xingwu.service.support.BaseServiceImpl;

/**
 *
 * UserRole 表数据服务层接口实现类
 *
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

	@Override
	public boolean existRoleUser( Long roleId ) {
		UserRole ur = new UserRole();
		ur.setRid(roleId);
		int rlt = baseMapper.selectCount(new EntityWrapper<UserRole>(ur));
		return rlt >= 1;
	}

}