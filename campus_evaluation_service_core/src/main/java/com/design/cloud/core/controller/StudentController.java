package com.design.cloud.core.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.common.exception.Assert;
import com.design.cloud.common.exception.MyException;
import com.design.cloud.common.result.ResponseEnum;
import com.design.cloud.common.result.Result;
import com.design.cloud.core.entity.Student;
import com.design.cloud.core.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学生信息管理 前端控制器
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "学生信息管理")
@RequestMapping("/admin/core/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    @ApiOperation("新增单个学生信息")
    public Result createStudent(
            @ApiParam(value = "学生信息对象", required = true)
            @RequestBody Student student) {

        Assert.notNull(student, ResponseEnum.OBJECT_NOT_NULL);

        boolean result = studentService.save(student);
        if (result) {
            return Result.success().message("新增成功");
        }
        return Result.fail().message("新增失败");
    }

    @PostMapping("/import")
    @ApiOperation("Excel数据的批量导入")
    public Result importUser(
            @ApiParam(value = "Excel学生数据信息", required = true)
            @RequestParam("file") MultipartFile file) {

        InputStream inputStream = null;

        try {
            inputStream = file.getInputStream();

            studentService.importStudent(inputStream);

            return Result.success().message("学生数据信息批量导入成功");
        } catch (Exception e) {
            throw new MyException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }

    @GetMapping("/search")
    @ApiOperation("根据学院专业班级姓名查询学生信息")
    public Result searchStudent(
            @ApiParam(value = "当前页", required = true)
            @RequestParam("current") Long current,
            @ApiParam(value = "页面大小", required = true)
            @RequestParam("size") Long size,
            @ApiParam(value = "学院id")
            @RequestParam("collegeId") Long collegeId,
            @ApiParam(value = "专业id")
            @RequestParam("professionId") Long professionId,
            @ApiParam(value = "班级id")
            @RequestParam("classId") Long classId,
            @ApiParam(value = "学生姓名")
            @RequestParam("studentName") String studentName
    ) {

        Page<Student> studentPage = new Page<>(current, size);

        IPage<Student> students = studentService.searchStudent(studentPage, collegeId, professionId, classId, studentName);

        return Result.success().message("查询成功").data("list", students);
    }

    @GetMapping("/list")
    @ApiOperation("分页查询所有学生信息")
    public Result listStudents(@ApiParam(value = "当前页", required = true)
                               @RequestParam("current") Long current,
                               @ApiParam(value = "页面大小", required = true)
                               @RequestParam("size") Long size) {

        Page<Student> page = new Page<>(current, size);

        Page<Student> studentPage = studentService.page(page);

        return Result.success().message("查询成功").data("list", studentPage);
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据学生编号获取学生信息")
    public Result getStudentById(
            @ApiParam(value = "学生编号", example = "100", required = true)
            @RequestParam("id") Long id) {
        Student student = studentService.getById(id);
        return Result.success().message("查询成功").data("student", student);
    }

    @PutMapping("/update")
    @ApiOperation("更新学生信息")
    public Result updateStudentById(
            @ApiParam(value = "学生信息对象", required = true)
            @RequestBody Student student) {

        Assert.notNull(student, ResponseEnum.OBJECT_NOT_NULL);

        boolean result = studentService.updateById(student);

        Assert.isTrue(result, ResponseEnum.OBJECT_UPDATE_FAIL);

        return Result.success().message("更新成功");
    }

    @DeleteMapping("/remove/{id}")
    @ApiOperation(value = "根据id删除单个学生信息", notes = "逻辑删除数据记录")
    public Result removeStudentById(
            @ApiParam(value = "学生编号", example = "100", required = true)
            @PathVariable("id") Long id) {

        boolean result = studentService.removeById(id);

        Assert.isTrue(result, ResponseEnum.OBJECT_DELETE_FAIL);

        return Result.success().message("删除成功");
    }

    @DeleteMapping("/remove")
    @ApiOperation(value = "根据id批量删除学生信息", notes = "批量逻辑删除")
    public Result batchDeleteStudent(
            @ApiParam(value = "学生id数组", required = true)
            @RequestBody Map<String, List<Long>> studentIds) {

        boolean result = studentService.removeByIds(studentIds.get("id"));

        Assert.isTrue(result, ResponseEnum.OBJECT_DELETE_FAIL);

        return Result.success().message("删除成功");
    }
}

