package com.bingo.modules.system.entity;

import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色用户关系
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleUserEntity extends BaseEntity {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 用户ID
     */
    private Long userId;

}
