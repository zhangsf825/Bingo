package com.bingo.modules.demo.service.impl;

import com.bingo.modules.demo.entity.DemoEntity;
import com.bingo.modules.demo.mapper.DemoMapper;
import com.bingo.modules.demo.service.IDemoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements IDemoService {

    @Resource
    private DemoMapper mapper;


    @Override
    public int selectCount() {

        return mapper.selectCount();
    }

    @Override
    public DemoEntity selectById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public List<DemoEntity> getList(DemoEntity entity) {
        return mapper.selectList(entity);
    }
}
