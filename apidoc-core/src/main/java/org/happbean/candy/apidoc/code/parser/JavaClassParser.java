package org.happbean.candy.apidoc.code.parser;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wgt
 * @date 2018-09-18
 * @description
 **/
public class JavaClassParser {


    public Map<String, Class[]> getParamsClass(Class clazz) {

        Method[] methods = clazz.getMethods();

        Map<String, Class[]> map = new HashMap<>();

        Arrays.stream(methods).forEach(method -> {
            Class[] paramTypes = method.getParameterTypes();
            map.put(method.toGenericString(), paramTypes);
        });

        return map;
    }

    public Map<String, Class> getReponseClass(Class clazz) {

        Method[] methods = clazz.getMethods();

        Map<String, Class> map = new HashMap<>();

        Arrays.stream(methods).forEach(method -> {
            Class<?> returnType = method.getReturnType();
            map.put(method.toGenericString(), returnType);
        });

        return map;
    }
}
