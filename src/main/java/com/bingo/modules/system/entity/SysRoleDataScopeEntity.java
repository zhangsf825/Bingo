package com.bingo.modules.system.entity;


import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色数据权限
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleDataScopeEntity extends BaseEntity {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 部门ID
     */
    private Long deptId;

}