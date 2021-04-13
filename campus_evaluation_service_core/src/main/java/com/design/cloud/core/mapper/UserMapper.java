package com.design.cloud.core.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.core.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息管理 Mapper 接口
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 普通分页和条件分页查询
     * @param userPage
     * @param nickName
     * @return
     */
    IPage<User> selectUserByPage(Page<User> userPage,@Param("nickName") String nickName);

}
