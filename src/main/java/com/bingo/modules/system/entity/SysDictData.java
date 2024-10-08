package com.bingo.modules.system.entity;

import com.bingo.crud.BaseEntity;
import lombok.Data;

/**
 *  字典数据
 */
@Data
public class SysDictData extends BaseEntity {

    private Long dictTypeId;
    private String dictLabel;
    private String dictValue;
}
