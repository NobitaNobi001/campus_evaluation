package com.design.cloud.core.mapper;

import com.design.cloud.core.entity.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.design.cloud.core.entity.dto.ExcelDictDTO;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
public interface DictMapper extends BaseMapper<Dict> {

    /**
     * 批量插入Dict
     * @param list
     */
    void insertBatch(List<ExcelDictDTO> list);

}
