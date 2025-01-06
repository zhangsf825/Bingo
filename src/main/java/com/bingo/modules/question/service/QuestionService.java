package com.bingo.modules.question.service;

import com.bingo.modules.question.entity.QuestionEntity;
import com.bingo.modules.question.mapper.QuestionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Resource
    private QuestionMapper mapper;


    public int selectCount() {

        return mapper.selectCount();
    }


    public QuestionEntity selectById(Long id) {
        return mapper.selectById(id);
    }


    public List<QuestionEntity> getList(QuestionEntity entity) {

        // Page<QuestionEntity> page = PageHelper.startPage(1,10);
        //
        //
        // List<QuestionEntity> questionEntityList = mapper.selectList(entity);
        //
        // long total = new PageInfo(questionEntityList).getTotal();
        //
        return mapper.selectList(entity);
    }

    public Long insert(QuestionEntity entity) {
        return mapper.insert(entity);
    }
}
