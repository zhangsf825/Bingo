package com.bingo.modules.system.entity;


import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 字典类型
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDictTypeEntity extends BaseEntity {
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序
     */
    private Integer sort;

}