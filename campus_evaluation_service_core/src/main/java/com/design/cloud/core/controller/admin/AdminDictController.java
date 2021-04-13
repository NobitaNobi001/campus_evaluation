package com.design.cloud.core.controller.admin;

import com.design.cloud.common.exception.MyException;
import com.design.cloud.common.result.ResponseEnum;
import com.design.cloud.common.result.Result;
import com.design.cloud.core.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Slf4j
@RestController
@Api(tags = "数据字典管理")
@RequestMapping("/admin/core/dict")
public class AdminDictController {

    @Resource
    private DictService dictService;

    @PostMapping("/import")
    @ApiOperation("Excel数据的批量导入")
    public Result batchImport(
            @ApiParam(value = "Excel数据字典文件", required = true)
            @RequestParam("file") MultipartFile file) {

        InputStream inputStream = null;
        try {

            inputStream = file.getInputStream();
            dictService.importData(inputStream);

            return Result.success().message("数据字典数据批量导入成功");

        } catch (Exception e) {
            throw new MyException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }

}
