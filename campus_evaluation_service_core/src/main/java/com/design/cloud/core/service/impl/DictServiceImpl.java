package com.design.cloud.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.design.cloud.core.entity.Dict;
import com.design.cloud.core.entity.dto.ExcelDictDTO;
import com.design.cloud.core.listener.ExcelDictDTOListener;
import com.design.cloud.core.mapper.DictMapper;
import com.design.cloud.core.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Slf4j
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void importData(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelDictDTO.class, new ExcelDictDTOListener(baseMapper)).sheet().doRead();
        log.info("Excel导入成功");

    }
}