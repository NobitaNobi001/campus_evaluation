package com.design.cloud.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.core.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息管理 服务类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询
     * @param userPage
     * @param nickName
     * @return
     */
    IPage<User> selectUserWithPage(Page userPage,String nickName);

}
