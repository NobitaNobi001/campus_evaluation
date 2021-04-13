package com.design.cloud.core.service.impl;

import com.design.cloud.core.entity.Project;
import com.design.cloud.core.mapper.ProjectMapper;
import com.design.cloud.core.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目发布管理表 服务实现类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

}
