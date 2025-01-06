package com.bingo.modules.demo.dto;

import com.bingo.common.validator.AddGroup;
import com.bingo.common.validator.DefaultGroup;
import com.bingo.common.validator.UpdateGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.io.Serializable;

@Data
public class DemoDTO implements Serializable {

    @Schema(description = "id")
    @Null(message = "ID必须为空", groups = AddGroup.class)
    @NotNull(message = "ID不能为空", groups = UpdateGroup.class)
    private Long id;

    @Schema(description = "类型")
    @NotBlank(message = "类型不能为空", groups = DefaultGroup.class)
    private String type;


    private String title;
    private String chapter;
    private String section;
    private String analysis;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String course;
    private String createTime;


}
