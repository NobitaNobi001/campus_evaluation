package com.design.cloud.core.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.core.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 学生信息管理 Mapper 接口
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 条件查询学生列表
     * @param studentPage
     * @return
     */
    IPage<Student> selectStudentWithCondition(Page<Student> studentPage);

}
