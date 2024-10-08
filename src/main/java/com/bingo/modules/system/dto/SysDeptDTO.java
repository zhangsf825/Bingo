package com.bingo.modules.system.dto;

import com.bingo.common.util.TreeNode;
import com.bingo.common.validator.AddGroup;
import com.bingo.common.validator.DefaultGroup;
import com.bingo.common.validator.UpdateGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.io.Serializable;

/**
 * 部门管理
 */
@Data
@Schema(description = "部门管理")
public class SysDeptDTO extends TreeNode implements Serializable {


    @Schema(description = "id")
    @Null(message = "ID必须为空", groups = AddGroup.class)
    @NotNull(message = "ID不能为空", groups = UpdateGroup.class)
    private Long id;

    @Schema(description = "上级ID")
    @NotNull(message = "上级ID不能为空", groups = DefaultGroup.class)
    private Long pid;

    @Schema(description = "部门名称")
    @NotBlank(message = "部门名称不能为空", groups = DefaultGroup.class)
    private String name;

    @Schema(description = "排序")
    @Min(value = 0, message = "排序不能为空", groups = DefaultGroup.class)
    private Integer sort;

    @Schema(description = "上级部门名称")
    private String parentName;

}