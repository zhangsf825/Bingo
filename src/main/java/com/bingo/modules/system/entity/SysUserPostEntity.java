package com.bingo.modules.system.entity;

import com.bingo.crud.BaseEntity;
import lombok.Data;

/**
 * 用户岗位关系
 */
@Data
public class SysUserPostEntity extends BaseEntity {

    /**
     * 岗位ID
     */
    private Long postId;
    /**
     * 用户ID
     */
    private Long userId;

}