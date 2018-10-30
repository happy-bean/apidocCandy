package org.happbean.candy.apidoc.code.parser;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


/**
 * @author wgt
 * @date 2018-09-18
 * @description
 **/
public class JavaClassParser {

    public static Method[] getMethods(Class clazz) {

        if (isJavaClass(clazz) == false) {
            return null;
        }

        return clazz.getMethods();
    }

    public static Parameter[] getParamsClass(Method method) {

        if (method == null) {
            return null;
        }

        return method.getParameters();
    }

    public static Class getReponseClass(Method method) {

        if (method == null) {
            return null;
        }

        return method.getReturnType();
    }

    private static boolean isJavaClass(Class<?> clazz) {
        return clazz != null && clazz.getClassLoader() != null;
    }
}
