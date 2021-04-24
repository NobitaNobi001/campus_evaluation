package com.design.cloud.core.service;

import com.design.cloud.core.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.design.cloud.core.entity.dto.ExcelDictDTO;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
public interface DictService extends IService<Dict> {

    /**
     * 批量导入字典数据
     * @param inputStream
     */
    void importData(InputStream inputStream);

    /**
     * 查询出所有字典数据
     * @return
     */
    List<ExcelDictDTO> listDictData();

    /**
     * 根据上级id查找字典数据
     * @param parentId
     * @return
     */
    List<Dict> listByParentId(Long parentId);
}
