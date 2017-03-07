package cn.org.xingwu.service.impl;

import cn.org.xingwu.service.support.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.framework.annotations.Log;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import cn.org.xingwu.entity.User;
import cn.org.xingwu.mapper.UserMapper;
import cn.org.xingwu.service.IRoleService;
import cn.org.xingwu.service.IUserService;
import cn.org.xingwu.service.support.BaseServiceImpl;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private IRoleService roleService;

	@Log("登录")
	@Override
	public User selectByLoginName(String loginName) {
		User user = new User();
		user.setLoginName(loginName);
		return super.selectOne(new EntityWrapper<User>(user));
	}

	@Log("删除用户")
	@Override
	public void deleteUser(Long userId) {
		// 删除用户角色，再删除用户
		roleService.deleteByUserId(userId);
		super.deleteById(userId);
	}

	@Log("添加用户")
	public boolean insert(User entity) {
		System.err.println(" 覆盖父类方法 ");
		return super.insert(entity);
	}
}