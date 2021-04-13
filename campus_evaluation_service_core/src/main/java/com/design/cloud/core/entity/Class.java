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
 * 班级管理
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Class对象", description="班级管理")
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班级id")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "班级名称")
    private String name;

    @ApiModelProperty(value = "所属专业")
    private Long professionId;

    @ApiModelProperty(value = "所属学院")
    private Long collegeId;

    @ApiModelProperty(value = "创建时间", example = "2021-04-10 08:00:00")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间", example = "2021-04-10 08:00:00")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除(0:未删除 1:已删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
