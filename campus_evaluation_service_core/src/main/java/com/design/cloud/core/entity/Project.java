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
 * 项目发布管理表
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Project对象", description="项目发布管理表")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目类别")
    private Long categoryId;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "项目申报截止时间")
    private LocalDateTime deadDate;

    @ApiModelProperty(value = "项目起始时间")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "项目截止时间")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "项目所需总人数")
    private Long totalNumber;

    @ApiModelProperty(value = "项目剩余所需人数")
    private Long remainNumber;

    @ApiModelProperty(value = "项目状态(0:申报中 1:在研中 2:已结题)")
    private Boolean status;

    @ApiModelProperty(value = "项目描述")
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
