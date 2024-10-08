package com.bingo.modules.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.bingo.common.util.DateUtils;
import com.bingo.common.validator.AddGroup;
import com.bingo.common.validator.DefaultGroup;
import com.bingo.common.validator.UpdateGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户管理
 */
@Data
@Schema(description = "用户管理")
public class SysUserDTO implements Serializable {

    @Schema(description = "id")
    @Null(message = "ID必须为空", groups = AddGroup.class)
    @NotNull(message = "ID不能为空", groups = UpdateGroup.class)
    private Long id;

    @Schema(description = "用户名", required = true)
    @NotBlank(message = "用户名不能为空", groups = DefaultGroup.class)
    private String username;

    @Schema(description = "密码")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "密码不能为空", groups = AddGroup.class)
    private String password;

    @Schema(description = "姓名", required = true)
    @NotBlank(message = "姓名不能为空", groups = DefaultGroup.class)
    private String realName;

    @Schema(description = "头像")
    private String headUrl;

    @Schema(description = "性别   0：男   1：女    2：保密", required = true)
    private Integer gender;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "部门ID", required = true)
    @NotNull(message = "部门ID不能为空", groups = DefaultGroup.class)
    private Long deptId;

    @Schema(description = "状态  0：停用    1：正常", required = true)
    @Range(min = 0, max = 1, message = "状态不能为空", groups = DefaultGroup.class)
    private Integer status;

    @Schema(description = "创建时间")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createDate;

    @Schema(description = "超级管理员   0：否   1：是")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer superAdmin;

    @Schema(description = "角色ID列表")
    private List<Long> roleIdList;

    @Schema(description = "岗位ID列表")
    private List<Long> postIdList;

    @Schema(description = "部门名称")
    private String deptName;

}