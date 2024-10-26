package com.bingo.modules.generator.service;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import com.bingo.common.util.MyException;
import com.bingo.modules.generator.entity.SchemaColumnEntity;
import com.bingo.modules.generator.entity.TableColumnEntity;
import com.bingo.modules.generator.mapper.GeneratorMapper;
import freemarker.template.Template;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeneratorService {

    @Resource
    private GeneratorMapper generatorMapper;

    private String gPackageName = "bingo";
    private String gModuleName = "demo";

    // 获取列数据
    public List<TableColumnEntity> getColumnListByName(String tableName){

        return generatorMapper.getColumnListByName(tableName);
    }


    // 创建列数据
    public void insertColumnListByName(String tableName) {

        // 获取列数据
        List<SchemaColumnEntity> schemaColumnEntityList = generatorMapper.getSchemaColumnByName(tableName);
        List<TableColumnEntity> tableColumnEntityList = new ArrayList<>();
        for(SchemaColumnEntity entity : schemaColumnEntityList){
            TableColumnEntity tableColumnEntity = new TableColumnEntity();

            tableColumnEntity.setTableName(tableName );

            tableColumnEntity.setColumnName(entity.getColumnName());
            tableColumnEntity.setDataType(entity.getDataType());
            tableColumnEntity.setColumnComment(entity.getColumnComment());

            String attrName = StringUtils.uncapitalize(columnToAttr(entity.getColumnName()));
            tableColumnEntity.setAttrName(attrName);

            String attrType =getAttrType(entity.getDataType());
            tableColumnEntity.setAttrType(attrType);
            tableColumnEntityList.add(tableColumnEntity);
        }

        // 保存列数据
        generatorMapper.insertColumnList(tableColumnEntityList);

    }


    public void createTemplateByName(String tableName) {

        //数据模型
        Map<String, Object> model = new HashMap<>();
        //项目信息
        model.put("package", gPackageName);
        model.put("packagePath", gPackageName.replace(".", File.separator));
        model.put("moduleName", gModuleName);
        model.put("tableComment", "部门管理");

        List<TableColumnEntity> tableColumnList = generatorMapper.getColumnListByName(tableName);
        model.put("columnList", tableColumnList);


        // 获取模板内容
        List<Map<String, String>> templateList = getTemplateList();
        for(Map<String, String> map : templateList){

            String template = map.get("template");
            String path = map.get("path");

            try {
                // 模板文件
                InputStream stTemplate = GeneratorService.class.getResourceAsStream(template);
                if (stTemplate == null) {
                    throw new MyException("模板文件 " + template + " 不存在");
                }
                // 读取模板内容
                String content = null;
                content = StreamUtils.copyToString(stTemplate, StandardCharsets.UTF_8);
                // 渲染文件
                String renderContent = getRenderContent(content, model);
                String renderPath = getRenderContent(path, model);
                // 生成文件
                FileUtil.writeUtf8String(renderContent, renderPath);

            } catch (IOException e) {
                throw new MyException("失败");
            }
        }
    }


    // 获取模板
    public static List<Map<String, String>> getTemplateList(){
        List<Map<String, String>> list = new ArrayList<>();


        Map map1 = new HashMap();
        map1.put("template", "/templates/Entity.java.ftl");
        map1.put("path", "${backendPath}/src/main/java/${packagePath}/modules/${moduleName}/entity/${subModuleName!}/${ClassName}Entity.java");
        list.add(map1);
        //
        // Map map2 = new HashMap();
        // map2.put("template", "/templates/Dao.java.ftl");
        // map2.put("path", "${backendPath}/src/main/java/${packagePath}/modules/${moduleName}/dao/${subModuleName!}/${ClassName}Dao.java");
        // list.add(map2);
        //
        // Map map3 = new HashMap();
        // map3.put("template", "/templates/Dao.xml.ftl");
        // map3.put("path", "${backendPath}/src/main/resources/mapper/${moduleName}/${ClassName}Dao.xml");
        // list.add(map3);
        //
        // Map map4 = new HashMap();
        // map4.put("template", "/templates/DTO.java.ftl");
        // map4.put("path", "${backendPath}/src/main/java/${packagePath}/modules/${moduleName}/dto/${subModuleName!}/${ClassName}DTO.jav");
        // list.add(map4);
        //
        // Map map5 = new HashMap();
        // map5.put("template", "/templates/Controller.java.ftl");
        // map5.put("path", "${backendPath}/src/main/java/${packagePath}/modules/${moduleName}/controller/${subModuleName!}/${ClassName}Controller.java");
        // list.add(map5);
        //
        // Map map6 = new HashMap();
        // map6.put("template", "/templates/Service.java.ftl");
        // map6.put("path", "${backendPath}/src/main/java/${packagePath}/modules/${moduleName}/service/${subModuleName!}/${ClassName}Service.java");
        // list.add(map6);
        //
        // Map map7 = new HashMap();
        // map7.put("template", "/templates/ServiceImpl.java.ftl");
        // map7.put("path", "${backendPath}/src/main/java/${packagePath}/modules/${moduleName}/service/${subModuleName!}/impl/${ClassName}ServiceImpl.java");
        // list.add(map7);

        return list;
    }

    /**
     * 渲染
     */
    public static String getRenderContent(String content, Map<String, Object> dataModel) {
        if (MapUtil.isEmpty(dataModel)) {
            return content;
        }

        StringReader reader = new StringReader(content);
        StringWriter sw = new StringWriter();
        try {
            //渲染模板
            String templateName = dataModel.getOrDefault("templateName", "generator").toString();
            Template template = new Template(templateName, reader, null, "utf-8");
            template.process(dataModel, sw);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("渲染模板失败，请检查模板语法", e);
        }

        content = sw.toString();

        IOUtils.closeQuietly(reader);
        IOUtils.closeQuietly(sw);

        return content;
    }

    /**
     * 列名转换成属性名
     */
    public static String columnToAttr(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }


    // 根据数据库的类型获取java中属性的类型
    public String getAttrType(String columnType){
        Map<String, String> map = new HashMap<>();

        map.put("int", "Integer");
        map.put("bigint", "Integer");
        map.put("tinyint", "Integer");
        map.put("varchar", "String");
        map.put("date", "Date");
        map.put("datetime", "Date");
        map.put("float", "Float");
        map.put("double", "Double");
        map.put("decimal", "BigDecimal");

        return map.get(columnType);
    }


}
