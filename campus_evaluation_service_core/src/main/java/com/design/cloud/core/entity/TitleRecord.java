package com.design.cloud.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 称号申报表
 * </p>
 *
 * @author ezuy
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TitleRecord对象", description="称号申报表")
public class TitleRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "称号类别编号")
    private Long titleId;

    @ApiModelProperty(value = "申请人编号")
    private Long applyUserId;

    @ApiModelProperty(value = "申报时间")
    private LocalDateTime applyDate;

    @ApiModelProperty(value = "申报材料")
    private String applyMaterial;

    @ApiModelProperty(value = "审核时间")
    private LocalDateTime auditDate;

    @ApiModelProperty(value = "审核意见")
    private String auditOption;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除(0:未删除 1:已删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
