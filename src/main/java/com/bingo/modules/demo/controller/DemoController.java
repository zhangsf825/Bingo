package com.bingo.modules.demo.controller;

import com.bingo.common.util.ResultBean;
import com.bingo.modules.demo.entity.DemoEntity;
import com.bingo.modules.demo.service.IDemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("demo")
@Tag(name = "Demo")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @Operation(summary = "根据ID查询")
    @GetMapping("{id}")
    public ResultBean<DemoEntity> info(@PathVariable("id") Long id) {

        DemoEntity entity = demoService.selectById(id);

        return new ResultBean<DemoEntity>().success(entity);
    }

    @Operation(summary = "查询数据总数")
    @GetMapping("getCount")
    public ResultBean<String> getCount() {

        int ret =demoService.selectCount();
        return new ResultBean<String>().success(String.valueOf(ret));
    }


    @Operation(summary = "查询所有数据")
    @PostMapping("getList")
    public ResultBean<List<DemoEntity>> getList(@RequestBody DemoEntity entity) {

        List<DemoEntity> list =  demoService.getList(entity);
        return new ResultBean<List<DemoEntity>>().success(list);
    }


    @Operation(summary = "保存数据")
    @PostMapping("insert")
    public ResultBean<String> insert(@RequestBody DemoEntity entity) {

        Long id =  demoService.insert(entity);
        return new ResultBean<String>().success(String.valueOf(id));
    }


}
