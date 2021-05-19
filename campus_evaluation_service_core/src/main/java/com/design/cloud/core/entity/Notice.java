package com.design.cloud.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 通知公告表
 * </p>
 *
 * @author ezuy
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Notice对象", description="通知公告表")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "类型(1通知 2公告)")
    private Boolean type;

    @ApiModelProperty(value = "公告内容")
    private String content;

    @ApiModelProperty(value = "状态(0 正常 1关闭)")
    private Boolean status;

    @ApiModelProperty(value = "创建者")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新者")
    private Long updateUserId;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除(0:未删除 1:已删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
