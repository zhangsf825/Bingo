package com.bingo.modules.question.controller;

import com.bingo.common.util.ResultBean;
import com.bingo.crud.PageData;
import com.bingo.modules.question.entity.QuestionEntity;
import com.bingo.modules.question.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topic")
@Tag(name = "topic")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @Operation(summary = "根据ID查询")
    @GetMapping("{id}")
    public ResultBean<QuestionEntity> info(@PathVariable("id") Long id) {

        QuestionEntity entity = service.selectById(id);
        return new ResultBean<QuestionEntity>().success(entity);
    }

    @Operation(summary = "查询数据总数")
    @GetMapping("getCount")
    public ResultBean<String> getCount() {

        int ret =service.selectCount();
        return new ResultBean<String>().success(String.valueOf(ret));
    }


    @Operation(summary = "查询所有数据")
    @PostMapping("getList")
    public ResultBean getList() {

        // PageHelper.startPage(1,10);
        //
        //
        // List<QuestionEntity> list =  service.getList(entity);
        //
        // long total = new PageInfo(list).getTotal();

        int ret =service.selectCount();
        // List<QuestionEntity> list =  service.getList(entity);
        List<QuestionEntity> list =  service.getList(new QuestionEntity());
        PageData pageData = new PageData<>(list, ret);
        return new ResultBean().success(pageData);
    }


    // @RequiresPermissions("demo:news:all")
    // public Result<PageData<NewsDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
    //     PageData<NewsDTO> page = newsService.page(params);
    //
    //     return new Result<PageData<NewsDTO>>().ok(page);
    // }

    @Operation(summary = "保存数据")
    @PostMapping("insert")
    public ResultBean<String> insert(@RequestBody QuestionEntity entity) {

        Long id =  service.insert(entity);
        return new ResultBean<String>().success(String.valueOf(id));
    }


}
