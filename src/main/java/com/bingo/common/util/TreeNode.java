package com.bingo.common.util;

import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 需要实现树节点的，继承该类
 */
@Data
public class TreeNode<T> implements Serializable {

    /**
     * 主键
     */
    private Long id;
    /**
     * 上级ID
     */
    private Long pid;
    /**
     * 子节点列表
     */
    private List<T> children = new ArrayList<>();

}