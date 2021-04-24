package com.design.cloud.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.core.entity.Student;
import com.design.cloud.core.entity.dto.ExcelStudentDTO;
import com.design.cloud.core.listener.ExcelStudentDTOListener;
import com.design.cloud.core.mapper.StudentMapper;
import com.design.cloud.core.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

/**
 * <p>
 * 学生信息管理 服务实现类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importStudent(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelStudentDTO.class, new ExcelStudentDTOListener(baseMapper)).sheet().doRead();
        log.info("批量导入成功");
    }

    @Override
    public IPage<Student> searchStudent(Page<Student> studentPage, Long collegeId, Long professionId, Long classId, String studentName) {

        // 封装条件
        QueryWrapper<Student> queryWrapper = new QueryWrapper();
        queryWrapper.like("student_name", studentName);
        queryWrapper.eq("college_id", collegeId);
        queryWrapper.eq("profession_id", professionId);
        queryWrapper.eq("class_id", classId);

        // 分页多条件查询
        Page<Student> page = baseMapper.selectPage(studentPage, queryWrapper);

        return page;
    }
}
