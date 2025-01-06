package com.bingo.crud;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 */
@Data
public abstract class BaseEntity implements Serializable {

    private Long id;

    private Long  creator;

    private Date createDate;

    private Long  updater;

    private Date updaterDate;
}