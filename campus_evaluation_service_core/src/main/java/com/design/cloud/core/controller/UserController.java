package com.design.cloud.core.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.common.exception.Assert;
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

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户信息管理 前端控制器
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Slf4j
@RestController
@Api(tags = "用户信息管理")
@RequestMapping("/admin/core/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("增加单个用户信息")
    @PostMapping("/save")
    public Result createUser(
            @ApiParam(value = "用户对象", required = true)
            @RequestBody User user) {

        // 断言表达式验证对象
        Assert.notNull(user, ResponseEnum.USER_NOT_NULL);

        boolean result = userService.save(user);
        if (result) {
            return Result.success().message("新增成功");
        }
        return Result.fail().message("新增失败");
    }


    @ApiOperation("普通分页查询和条件分页查询用户信息")
    @GetMapping("/list")
    public Result listUser(
            @ApiParam(value = "当前页", required = true)
            @RequestParam("current") Long current,
            @ApiParam(value = "页面大小", required = true)
            @RequestParam("size") Long size,
            @ApiParam(value = "用户姓名")
            @RequestParam(value = "nickName",required = false) String nickName) {

        Page<User> userPage = new Page<>(current, size);

        IPage<User> users = userService.selectUserWithPage(userPage, nickName);

        return Result.success().message("查询成功").data("list", users);
    }

    @ApiOperation("更新单个用户信息")
    @PutMapping("/update")
    public Result updateUser() {
        return null;
    }

    @ApiOperation(value = "根据id删除单个用户信息", notes = "逻辑删除数据记录")
    @DeleteMapping("/remove/{id}")
    public Result deleteUser(
            @ApiParam(value = "用户id", example = "100", required = true)
            @PathVariable("id") Long id) {

        boolean result = userService.removeById(id);

        if (result) {
            return Result.success().message("删除成功");
        }
        return Result.fail().message("删除失败");
    }
}

