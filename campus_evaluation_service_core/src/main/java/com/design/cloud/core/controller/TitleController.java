package com.design.cloud.core.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.cloud.common.result.Result;
import com.design.cloud.core.entity.Title;
import com.design.cloud.core.service.TitleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 称号评定表 前端控制器
 * </p>
 *
 * @author ezuy
 * @since 2021-05-10
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "称号信息发布管理")
@RequestMapping("/core/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping("/list")
    @ApiOperation("分页查询所有称号评定信息")
    public Result listRecord(@ApiParam(value = "当前页", required = true)
                                 @RequestParam("current") Long current,
                             @ApiParam(value = "页面大小", required = true)
                                 @RequestParam("size") Long size){

        Page<Title> titlePage = new Page<>(current,size);

        Page<Title> titlePages = titleService.page(titlePage);

        return Result.success().message("查询成功").data("list", titlePage);
    }
}

