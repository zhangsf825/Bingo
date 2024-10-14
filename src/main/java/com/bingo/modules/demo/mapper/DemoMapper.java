package com.bingo.modules.demo.mapper;

import com.bingo.modules.demo.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper {

    int selectCount();

    DemoEntity selectById(Long id);

    List<DemoEntity> selectList(DemoEntity entity);

    Long insert(DemoEntity entity);
}
