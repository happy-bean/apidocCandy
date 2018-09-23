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

    private Class clazz;

    public JavaClassParser(Class clazz) {
        this.clazz = clazz;
    }

    public Map<String, Class[]> getParamsClass() {

        Method[] methods = this.clazz.getMethods();

        Map<String, Class[]> map = new HashMap<>();

        Arrays.stream(methods).forEach(method -> {
            Class[] paramTypes = method.getParameterTypes();
            map.put(method.toGenericString(), paramTypes);
        });

        return map;
    }

    public Map<String, Class> getReponseClass() {

        Method[] methods = this.clazz.getMethods();

        Map<String, Class> map = new HashMap<>();

        Arrays.stream(methods).forEach(method -> {

            if (AnnotationParser.checkMethodAnnotation(method)) {
                Class<?> returnType = method.getReturnType();
                map.put(method.toGenericString(), returnType);
            }
        });

        return map;
    }

    public static boolean isJavaClass(Class<?> clazz) {
        return clazz != null && clazz.getClassLoader() == null;
    }
}
