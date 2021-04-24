package com.design.cloud.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.design.cloud.core.entity.dto.ExcelUserDTO;
import com.design.cloud.core.mapper.UserMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ezuy
 * @date 21/4/23 21:20
 */
@Slf4j
@NoArgsConstructor
public class ExcelUserDTOListener extends AnalysisEventListener<ExcelUserDTO> {

    private UserMapper userMapper;

    public ExcelUserDTOListener(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void invoke(ExcelUserDTO excelUserDTO, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}