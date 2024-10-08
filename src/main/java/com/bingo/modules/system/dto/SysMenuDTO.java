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
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * 菜单管理
 */
@Data
@Schema(description = "菜单管理")
public class SysMenuDTO extends TreeNode<SysMenuDTO> implements Serializable {

    @Schema(description = "id")
    @Null(message = "ID必须为空", groups = AddGroup.class)
    @NotNull(message = "ID不能为空", groups = UpdateGroup.class)
    private Long id;

    @Schema(description = "上级ID")
    @NotNull(message = "上级ID不能为空", groups = DefaultGroup.class)
    private Long pid;

    @Schema(description = "菜单名称")
    @NotBlank(message = "菜单名称不能为空", groups = DefaultGroup.class)
    private String name;

    @Schema(description = "菜单URL")
    private String url;

    @Schema(description = "类型  0：菜单   1：按钮")
    @Range(min = 0, max = 1, message = "类型不能为空", groups = DefaultGroup.class)
    private Integer menuType;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "授权(多个用逗号分隔，如：sys:user:list,sys:user:save)")
    private String permissions;

    @Schema(description = "排序")
    @Min(value = 0, message = "排序不能为空", groups = DefaultGroup.class)
    private Integer sort;

    @Schema(description = "上级菜单名称")
    private String parentName;

}