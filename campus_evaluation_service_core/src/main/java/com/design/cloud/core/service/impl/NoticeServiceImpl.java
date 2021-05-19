package com.design.cloud.core.service.impl;

import com.design.cloud.core.entity.Notice;
import com.design.cloud.core.mapper.NoticeMapper;
import com.design.cloud.core.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author ezuy
 * @since 2021-05-10
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}
