package com.bingo.modules.question.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门管理
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionEntity {

    private Long id;
    private String type;
    private String content;
    private String chapter;
    private String section;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String solution;
    private String course;
}