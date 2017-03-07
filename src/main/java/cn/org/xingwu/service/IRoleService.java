package cn.org.xingwu.service;

import com.baomidou.mybatisplus.service.IService;
import cn.org.xingwu.entity.Role;

/**
 *
 * Role 表数据服务层接口
 *
 */
public interface IRoleService extends IService<Role> {

	void deleteByUserId(Long userId);

}
