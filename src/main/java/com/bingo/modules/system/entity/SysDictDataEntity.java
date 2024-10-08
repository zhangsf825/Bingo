package com.bingo.modules.system.entity;


import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 数据字典
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDictDataEntity extends BaseEntity {
    /**
     * 字典类型ID
     */
    private Long dictTypeId;
    /**
     * 字典标签
     */
    private String dictLabel;
    /**
     * 字典值
     */
    private String dictValue;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序
     */
    private Integer sort;

}