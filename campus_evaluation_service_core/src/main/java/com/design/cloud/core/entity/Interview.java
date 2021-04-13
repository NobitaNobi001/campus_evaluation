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
 * 
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Interview对象", description="")
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "岗位类别")
    private Long categoryId;

    @ApiModelProperty(value = "岗位名称")
    private String name;

    @ApiModelProperty(value = "申报截止日期")
    private LocalDateTime deadDate;

    @ApiModelProperty(value = "任职起始时间")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "任职结束时间")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "岗位所需总人数")
    private Long totalNumber;

    @ApiModelProperty(value = "岗位剩余所需人数")
    private Long remainNumber;

    @ApiModelProperty(value = "项目状态(0:招聘中  1:招聘结束)")
    private Boolean status;

    @ApiModelProperty(value = "岗位描述")
    private String description;

    @ApiModelProperty(value = "创建时间", example = "2021-04-10 08:00:00")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间", example = "2021-04-10 08:00:00")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除(0:未删除 1:已删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
