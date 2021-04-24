package com.design.cloud.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.core.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

/**
 * <p>
 * 学生信息管理 服务类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
public interface StudentService extends IService<Student> {

    /**
     * 批量导入学生数据信息
     * @param inputStream
     */
    void importStudent(InputStream inputStream);

    /**
     * 条件查询
     * @param studentPage
     * @param collegeId
     * @param professionId
     * @param classId
     * @param studentName
     * @return
     */
    IPage<Student> searchStudent(Page<Student> studentPage,Long collegeId, Long professionId, Long classId, String studentName);
}
