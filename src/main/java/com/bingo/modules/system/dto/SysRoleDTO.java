package com.bingo.modules.system.dto;

import com.bingo.common.validator.AddGroup;
import com.bingo.common.validator.DefaultGroup;
import com.bingo.common.validator.UpdateGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色管理
 */
@Data
@Schema(description = "角色管理")
public class SysRoleDTO implements Serializable {

    @Schema(description = "id")
    @Null(message = "ID必须为空", groups = AddGroup.class)
    @NotNull(message = "ID不能为空", groups = UpdateGroup.class)
    private Long id;

    @Schema(description = "角色名称")
    @NotBlank(message = "角色名称不能为空", groups = DefaultGroup.class)
    private String name;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "菜单ID列表")
    private List<Long> menuIdList;

    @Schema(description = "部门ID列表")
    private List<Long> deptIdList;

}