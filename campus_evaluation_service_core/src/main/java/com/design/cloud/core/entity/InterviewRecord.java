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
 * 
 * </p>
 *
 * @author ezuy
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="InterviewRecord对象", description="")
public class InterviewRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "岗位id")
    private Long interviewId;

    @ApiModelProperty(value = "岗位申报人账号")
    private String applyUserName;

    @ApiModelProperty(value = "岗位申报人")
    private String applyPerson;

    @ApiModelProperty(value = "岗位申报日期")
    private LocalDateTime applyDate;

    @ApiModelProperty(value = "岗位申报描述")
    private String applyDescription;

    @ApiModelProperty(value = "岗位申报审核状态(0:审核中 1:审核通过 2:审核失败)")
    private Boolean status;

    @ApiModelProperty(value = "创建时间", example = "2021-04-10 08:00:00")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间", example = "2021-04-10 08:00:00")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除(0:未删除 1:已删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
