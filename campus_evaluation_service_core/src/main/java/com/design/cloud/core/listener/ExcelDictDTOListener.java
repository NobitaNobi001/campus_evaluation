package com.design.cloud.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.design.cloud.core.entity.dto.ExcelDictDTO;
import com.design.cloud.core.mapper.DictMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ezuy
 * @date 21/4/10 19:13
 */
@Slf4j
@NoArgsConstructor
public class ExcelDictDTOListener extends AnalysisEventListener<ExcelDictDTO> {

    private DictMapper dictMapper;

    /**
     * 数据列表
     */
    List<ExcelDictDTO> list = new ArrayList<>();

    /**
     * 每5条数据批量存储一次数据
     */
    private static final int BATCH_COUNT = 5;

    public ExcelDictDTOListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    @Override
    public void invoke(ExcelDictDTO excelDictDTO, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", excelDictDTO);
        // 将数据存入数据列表
        list.add(excelDictDTO);
        // 存数据
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 剩余数据存储
        saveData();
        log.info("所有数据解析完成");
    }

    private void saveData() {
        log.info("{}条数据存储到数据库中", list.size());
        dictMapper.insertBatch(list);
        log.info("{}条数据成功存储到数据库", list.size());
    }
}
