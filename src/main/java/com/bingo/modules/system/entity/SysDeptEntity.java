package com.bingo.modules.system.entity;


import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门管理
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDeptEntity extends BaseEntity {
    /**
     * 上级ID
     */
    private Long pid;
    /**
     * 所有上级ID，用逗号分开
     */
    private String pids;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 上级部门名称
     */
    private String parentName;

}