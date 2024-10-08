package com.bingo.modules.system.entity;

import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 角色
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 部门ID
     */
    private Long deptId;

}
