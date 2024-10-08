package com.bingo.modules.system.dto;

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
 * 字典数据
 */
@Data
@Schema(description = "字典数据")
public class SysDictDataDTO implements Serializable {

    @Schema(description = "id")
    @Null(message = "ID必须为空", groups = AddGroup.class)
    @NotNull(message = "ID不能为空", groups = UpdateGroup.class)
    private Long id;

    @Schema(description = "字典类型ID")
    @NotNull(message = "字典类型ID不能为空", groups = DefaultGroup.class)
    private Long dictTypeId;

    @Schema(description = "字典标签")
    @NotBlank(message = "字典标签不能为空", groups = DefaultGroup.class)
    private String dictLabel;

    @Schema(description = "字典值")
    private String dictValue;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "排序")
    @Min(value = 0, message = "排序不能为空", groups = DefaultGroup.class)
    private Integer sort;

}