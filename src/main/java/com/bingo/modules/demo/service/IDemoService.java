package com.bingo.modules.demo.service;

import com.bingo.modules.demo.entity.DemoEntity;

import java.util.List;

public interface IDemoService {

    int selectCount();

    DemoEntity selectById(Long id);

    List<DemoEntity> getList(DemoEntity entity);
}
