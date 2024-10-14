package com.bingo.modules.demo.mapper;

import com.bingo.modules.demo.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper {

    public int selectCount();

    public DemoEntity selectById(Long id);

    public List<DemoEntity> selectList(DemoEntity entity);
}
