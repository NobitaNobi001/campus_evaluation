package com.design.cloud.core.service.impl;

import com.design.cloud.core.entity.Class;
import com.design.cloud.core.mapper.ClassMapper;
import com.design.cloud.core.service.ClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级管理 服务实现类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

}
