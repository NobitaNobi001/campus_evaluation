package com.design.cloud.core.controller.admin;

import com.alibaba.excel.EasyExcel;
import com.design.cloud.common.exception.MyException;
import com.design.cloud.common.result.ResponseEnum;
import com.design.cloud.common.result.Result;
import com.design.cloud.core.entity.Dict;
import com.design.cloud.core.entity.dto.ExcelDictDTO;
import com.design.cloud.core.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "数据字典管理")
@RequestMapping("/admin/core/dict")
public class AdminDictController {

    @Resource
    private DictService dictService;

    @ApiOperation("根据上级id获取子节点数据列表")
    @GetMapping("/listByParentId/{parentId}")
    public Result listByParentId(@ApiParam(value = "上级节点id", required = true)
                                 @PathVariable Long parentId) {

        List<Dict> dictList = dictService.listByParentId(parentId);

        return Result.success().data("list", dictList);
    }

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

    @GetMapping("/export")
    @ApiOperation("批量导出数据为Excel文件")
    public void batchExport(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("mydict", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ExcelDictDTO.class).sheet("数据字典").doWrite(dictService.listDictData());
    }

}
