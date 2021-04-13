package com.design.cloud.core.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.core.entity.User;
import com.design.cloud.core.mapper.UserMapper;
import com.design.cloud.core.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息管理 服务实现类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Service
public class UserServiceImpl extends
        ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public IPage<User> selectUserWithPage(Page userPage,String nickName) {
        return baseMapper.selectUserByPage(userPage,nickName);
    }
}
