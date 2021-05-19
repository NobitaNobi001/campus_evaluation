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
 * 奖助学金申报记录表
 * </p>
 *
 * @author ezuy
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ScholarShipRecord对象", description="奖助学金申报记录表")
public class ScholarShipRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "奖助学金编号")
    private Long scholarShipId;

    @ApiModelProperty(value = "学生编号")
    private Long applyStudentId;

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
