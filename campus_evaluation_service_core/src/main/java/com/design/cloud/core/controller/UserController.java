package com.design.cloud.core.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.common.exception.Assert;
import com.design.cloud.common.exception.MyException;
import com.design.cloud.common.result.ResponseEnum;
import com.design.cloud.common.result.Result;
import com.design.cloud.core.entity.User;
import com.design.cloud.core.service.UserService;
import com.mysql.cj.protocol.ResultsetRow;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息管理 前端控制器
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "用户信息管理")
@RequestMapping("/admin/core/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/save")
    @ApiOperation("增加单个用户信息")
    public Result createUser(
            @ApiParam(value = "用户对象", required = true)
            @RequestBody User user) {

        // 断言表达式验证对象
        Assert.notNull(user, ResponseEnum.OBJECT_NOT_NULL);

        boolean result = userService.save(user);
        if (result) {
            return Result.success().message("新增成功");
        }
        return Result.fail().message("新增失败");
    }

    @PostMapping("/import")
    @ApiOperation("Excel数据的批量导入")
    public Result importUser(
            @ApiParam(value = "Excel用户数据信息", required = true)
            @RequestParam("file") MultipartFile file) {

        InputStream inputStream = null;

        try {
            inputStream = file.getInputStream();

            userService.importUser(inputStream);

            return Result.success().message("用户数据批量导入成功");
        } catch (Exception e) {
            throw new MyException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }

    @GetMapping("/list")
    @ApiOperation("普通分页查询和条件分页查询用户信息")
    public Result listUser(
            @ApiParam(value = "当前页", required = true)
            @RequestParam("current") Long current,
            @ApiParam(value = "页面大小", required = true)
            @RequestParam("size") Long size,
            @ApiParam(value = "用户姓名")
            @RequestParam(value = "nickName", required = false) String nickName) {

        Page<User> userPage = new Page<>(current, size);

        IPage<User> users = userService.selectUserWithPage(userPage, nickName);

        return Result.success().message("查询成功").data("list", users);
    }

    @GetMapping("/get")
    @ApiOperation("根据用户编号获取单个用户信息")
    public Result getUserByUserId(
            @ApiParam(value = "用户编号", example = "100", required = true)
            @RequestParam("userId") Long userId) {

        User user = userService.getUserByUserId(userId);
        return Result.success().message("查询成功").data("user", user);
    }

    @PutMapping("/update")
    @ApiOperation("更新单个用户信息")
    public Result updateUser(
            @ApiParam(value = "用户信息", required = true)
            @RequestBody User user) {

        boolean result = userService.updateById(user);

        Assert.isTrue(result, ResponseEnum.OBJECT_UPDATE_FAIL);

        return Result.success().message("更新成功");
    }

    @DeleteMapping("/remove/{id}")
    @ApiOperation(value = "根据id删除单个用户信息", notes = "逻辑删除数据记录")
    public Result deleteUser(
            @ApiParam(value = "用户id", example = "100", required = true)
            @PathVariable("id") Long id) {

        boolean result = userService.removeById(id);

        Assert.isTrue(result, ResponseEnum.OBJECT_DELETE_FAIL);

        return Result.success().message("删除成功");
    }

    @DeleteMapping("/remove")
    @ApiOperation(value = "根据id批量删除用户信息", notes = "批量逻辑删除")
    public Result batchDeleteUser(
            @ApiParam(value = "用户id数组", required = true)
            @RequestBody Map<String, List<Long>> userIds) {

        boolean result = userService.removeByIds(userIds.get("userId"));

        Assert.isTrue(result, ResponseEnum.OBJECT_DELETE_FAIL);

        return Result.success().message("删除成功");

    }
}

