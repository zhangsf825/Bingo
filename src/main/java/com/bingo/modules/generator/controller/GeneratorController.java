package com.bingo.modules.generator.controller;

import com.bingo.common.util.ResultBean;
import com.bingo.modules.generator.entity.TableColumnEntity;
import com.bingo.modules.generator.service.GeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(" Generator")
@Tag(name = "Generator")
public class GeneratorController {

    @Autowired
    private GeneratorService service;


    @Operation(summary = "查询列数据")
    @GetMapping("{tableName}")
    public ResultBean<List<TableColumnEntity>> getColumnListByName(@PathVariable("tableName") String tableName) {

        List<TableColumnEntity> list = service.getColumnListByName(tableName);
        return new ResultBean<List<TableColumnEntity>>().success(list);
    }


    @Operation(summary = "创建列数据")
    @GetMapping("insertColumn/{tableName}")
    public void insertColumnListByName(@PathVariable("tableName") String tableName) {

        service.insertColumnListByName(tableName);

    }

    @Operation(summary = "根据模板创建文件")
    @GetMapping("createFile/{tableName}")
    public void createTemplateByName(@PathVariable("tableName") String tableName) {

        service.createTemplateByName(tableName);

    }
}
