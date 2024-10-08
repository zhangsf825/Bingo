package com.bingo.modules.system.entity;


import com.bingo.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 岗位管理
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysPostEntity extends BaseEntity {

    /**
     * 岗位名称
     */
    private String postCode;
    /**
     * 岗位名称
     */
    private String postName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     */
    private Integer status;

}