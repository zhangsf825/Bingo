package com.bingo.modules.system.entity;

import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色菜单关系
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleMenuEntity extends BaseEntity {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;

}
