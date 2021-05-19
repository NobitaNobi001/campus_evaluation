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
 * 奖助学金信息发布表
 * </p>
 *
 * @author ezuy
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ScholarShip对象", description="奖助学金信息发布表")
public class ScholarShip implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "奖助学金类别编号")
    private Long scholarShipCategoryId;

    @ApiModelProperty(value = "面向学生年级")
    private Long studentGradeId;

    @ApiModelProperty(value = "申报截止时间")
    private LocalDateTime deadDate;

    @ApiModelProperty(value = "所评定总人数")
    private Long totalNumber;

    @ApiModelProperty(value = "剩余可评定人数")
    private Long remainNumber;

    @ApiModelProperty(value = "申报状态(0:申报中  1:申报结束)")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除(0:未删除 1:已删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
