package com.bingo.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 岗位管理
 */
@Data
@Schema(description = "岗位管理")
public class SysPostDTO implements Serializable {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "岗位编码")
    private String postCode;
    @Schema(description = "岗位名称")
    private String postName;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "状态")
    private Integer status;

}