package com.design.cloud.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.design.cloud.core.entity.dto.ExcelStudentDTO;
import com.design.cloud.core.mapper.StudentMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ezuy
 * @date 21/4/24 21:28
 */
@Slf4j
@NoArgsConstructor
public class ExcelStudentDTOListener extends AnalysisEventListener<ExcelStudentDTO> {

    private StudentMapper studentMapper;

    public ExcelStudentDTOListener(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public void invoke(ExcelStudentDTO excelStudentDTO, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}