package com.bingo.crud;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 */
@Data
@Schema(description = "分页数据")
public class PageData<T> implements Serializable {
    @Schema(description = "总记录数")
    private int total;

    @Schema(description = "列表数据")
    private List<T> list;

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public PageData(List<T> list, long total) {
        this.list = list;
        this.total = (int) total;
    }
}