package cn.org.xingwu.mapper;

import java.util.List;

import cn.org.xingwu.entity.Permission;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import cn.org.xingwu.entity.Permission;
import cn.org.xingwu.entity.vo.MenuVO;

/**
 *
 * Permission 表数据库控制层接口
 *
 */
public interface PermissionMapper extends BaseMapper<Permission> {

	List<MenuVO> selectMenuByUserId(@Param("userId") Long userId, @Param("pid") Long pid);

	List<Permission> selectAllByUserId(@Param("userId") Long userId);

}