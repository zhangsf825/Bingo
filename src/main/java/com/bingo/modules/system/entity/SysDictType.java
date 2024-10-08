package com.bingo.modules.system.entity;

import com.bingo.crud.BaseEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典类型
 */
@Data
public class SysDictType extends BaseEntity {

    private String dictType;
    private List<SysDictData> dataList = new ArrayList<>();
}
