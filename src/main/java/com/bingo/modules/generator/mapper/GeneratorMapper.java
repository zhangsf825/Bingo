package com.bingo.modules.generator.mapper;


import com.bingo.modules.generator.entity.SchemaColumnEntity;
import com.bingo.modules.generator.entity.TableColumnEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GeneratorMapper {

    List<TableColumnEntity> getColumnListByName(String tableName);

    List<SchemaColumnEntity> getSchemaColumnByName(String tableName);

    // 创建列数据
    void insertColumnList(List<TableColumnEntity>  list);
}
