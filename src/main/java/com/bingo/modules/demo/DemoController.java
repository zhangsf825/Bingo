package com.bingo.modules.demo;

import com.bingo.common.util.ResultBean;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo/demo")
@Tag(name = "Demo")
public class DemoController {

    @Operation(summary = "根据ID查询")
    @GetMapping("{id}")
    public ResultBean<DemoDTO> info(@PathVariable("id") Long id) {

        DemoDTO dto = new DemoDTO();
        dto.setId(1L);
        dto.setType("内容");

        return new ResultBean<DemoDTO>().success(dto);
    }

    @Operation(summary = "返回")
    @GetMapping()
    public String ret() {

        return "123";
    }
}
