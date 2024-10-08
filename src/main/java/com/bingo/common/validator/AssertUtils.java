package com.bingo.common.validator;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import com.bingo.common.util.MyException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 校验工具类
 */
public class AssertUtils {

    public static void isBlank(String str, String params) {
        isBlank(str, 10001, params);
    }

    public static void isBlank(String str, Integer code, String params) {
        if(code == null){
            throw new MyException(10001, "code");
        }

        if (StringUtils.isBlank(str)) {
            throw new MyException(code, params);
        }
    }

    public static void isNull(Object object, String params) {
        isNull(object, 10001, params);
    }

    public static void isNull(Object object, Integer code, String params) {
        if(code == null){
            throw new MyException(10001, "code");
        }

        if (object == null) {
            throw new MyException(code, params);
        }
    }

    public static void isArrayEmpty(Object[] array, String params) {
        isArrayEmpty(array, 10001, params);
    }

    public static void isArrayEmpty(Object[] array, Integer code, String params) {
        if(code == null){
            throw new MyException(10001, "code");
        }

        if(ArrayUtil.isEmpty(array)){
            throw new MyException(code, params);
        }
    }

    public static void isListEmpty(List<?> list, String params) {
        isListEmpty(list, 10001, params);
    }

    public static void isListEmpty(List<?> list, Integer code, String params) {
        if(code == null){
            throw new MyException(10001, "code");
        }

        if(CollUtil.isEmpty(list)){
            throw new MyException(code, params);
        }
    }

    public static void isMapEmpty(Map map, String params) {
        isMapEmpty(map, 10001, params);
    }

    public static void isMapEmpty(Map map, Integer code, String params) {
        if(code == null){
            throw new MyException(10001, "code");
        }

        if(MapUtil.isEmpty(map)){
            throw new MyException(code, params);
        }
    }
}