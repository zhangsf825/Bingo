package com.bingo.modules.question.mapper;

import com.bingo.modules.question.entity.QuestionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    int selectCount();

    QuestionEntity selectById(Long id);

    List<QuestionEntity> selectList(QuestionEntity entity);

    Long insert(QuestionEntity entity);
}
