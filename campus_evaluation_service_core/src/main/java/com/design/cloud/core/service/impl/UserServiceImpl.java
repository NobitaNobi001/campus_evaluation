package com.design.cloud.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.common.exception.Assert;
import com.design.cloud.common.result.ResponseEnum;
import com.design.cloud.core.entity.User;
import com.design.cloud.core.entity.dto.ExcelUserDTO;
import com.design.cloud.core.listener.ExcelUserDTOListener;
import com.design.cloud.core.mapper.UserMapper;
import com.design.cloud.core.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

/**
 * <p>
 * 用户信息管理 服务实现类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Slf4j
@Service
public class UserServiceImpl extends
        ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public IPage<User> selectUserWithPage(Page userPage,String nickName) {
        return baseMapper.selectUserByPage(userPage,nickName);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importUser(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelUserDTO.class,new ExcelUserDTOListener(baseMapper)).sheet().doRead();
        log.info("Excel导入成功");
    }

    @Override
    public User getUserByUserId(Long userId) {

        User user = baseMapper.selectById(userId);

        Assert.notNull(user, ResponseEnum.USER_IS_NULL);

        return user;
    }
}
