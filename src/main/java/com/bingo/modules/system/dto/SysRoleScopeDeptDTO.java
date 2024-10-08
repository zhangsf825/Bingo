package com.bingo.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 数据权限，下拉框显示
 */
@Data
@Schema(description = "数据权限")
public class SysRoleScopeDeptDTO {

    private Long deptId;

    private String deptName;
}
