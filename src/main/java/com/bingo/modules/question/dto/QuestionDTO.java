package com.bingo.modules.question.dto;

import com.bingo.common.validator.AddGroup;
import com.bingo.common.validator.UpdateGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionDTO implements Serializable {

    @Schema(description = "id")
    @Null(message = "ID必须为空", groups = AddGroup.class)
    @NotNull(message = "ID不能为空", groups = UpdateGroup.class)
    private Long id;

    @Schema(description = "题目类型")
    private String type;
    @Schema(description = "题目")
    private String content;
    @Schema(description = "章")
    private String chapter;
    @Schema(description = "节")
    private String section;

    @Schema(description = "选项A")
    private String option1;
    @Schema(description = "选项B")
    private String option2;
    @Schema(description = "选项C")
    private String option3;
    @Schema(description = "选项D")
    private String option4;
    @Schema(description = "答案")
    private String answer;
    @Schema(description = "题目分析")
    private String solution;
    @Schema(description = "科目")
    private String course;


}
