package com.design.cloud.core.service.impl;

import com.design.cloud.core.entity.Student;
import com.design.cloud.core.mapper.StudentMapper;
import com.design.cloud.core.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息管理 服务实现类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
