package com.bingo.modules.system.entity;

import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单管理
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenuEntity extends BaseEntity {
    /**
     * 父菜单ID，一级菜单为0
     */
    private Long pid;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 授权(多个用逗号分隔，如：sys:user:list,sys:user:save)
     */
    private String permissions;
    /**
     * 类型   0：菜单   1：按钮
     */
    private Integer menuType;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sort;

    /**
     * 上级菜单名称
     */
    private String parentName;

}