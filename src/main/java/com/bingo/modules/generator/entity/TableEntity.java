package com.bingo.modules.generator.entity;

import java.io.Serializable;
import java.util.List;


public class TableEntity implements Serializable {

    private Long id;
    private String tableName;
    private String tableComment;
    private String className;
    private String packageName;
    private String backendPath;
    private String frontendPath;
    private String moduleName;
    private String subModuleName;
    private List<TableColumnEntity> fields;
    private TableColumnEntity pk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getBackendPath() {
        return backendPath;
    }

    public void setBackendPath(String backendPath) {
        this.backendPath = backendPath;
    }

    public String getFrontendPath() {
        return frontendPath;
    }

    public void setFrontendPath(String frontendPath) {
        this.frontendPath = frontendPath;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public List<TableColumnEntity> getFields() {
        return fields;
    }

    public void setFields(List<TableColumnEntity> fields) {
        this.fields = fields;
    }

    public TableColumnEntity getPk() {
        return pk;
    }

    public void setPk(TableColumnEntity pk) {
        this.pk = pk;
    }
}
