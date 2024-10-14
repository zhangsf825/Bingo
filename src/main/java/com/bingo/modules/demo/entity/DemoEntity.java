package com.bingo.modules.demo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门管理
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DemoEntity  {

    private Long id;

    private String studName;


}