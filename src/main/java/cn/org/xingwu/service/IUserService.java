package cn.org.xingwu.service;

import cn.org.xingwu.entity.User;
import com.baomidou.mybatisplus.service.IService;
import cn.org.xingwu.entity.User;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface IUserService extends IService<User> {

	User selectByLoginName(String loginName);

	void deleteUser(Long userId);

}