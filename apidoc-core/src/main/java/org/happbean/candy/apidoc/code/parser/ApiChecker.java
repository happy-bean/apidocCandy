package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.internal.annotation.Api;
import org.happbean.candy.apidoc.internal.annotation.request.Action;
import org.happbean.candy.apidoc.internal.annotation.request.Param;
import org.happbean.candy.apidoc.internal.annotation.response.Result;
import org.happbean.candy.apidoc.util.CollectionUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @author wgt
 * @date 2018-10-25
 * @description
 **/
public class ApiChecker {

    public static boolean isApiClass(Class clazz) {

        Annotation annotation = clazz.getAnnotation(Api.class);

        return annotation == null ? false : true;
    }

    public static boolean isApiMethod(Method method) {

        Annotation[] annotations = method.getAnnotations();

        if (CollectionUtil.isEmpty(Arrays.asList(annotations))) {
            return false;
        }

        for (Annotation annotation : annotations) {

            if (annotation instanceof Action) {
                return true;
            }
        }
        return false;
    }

    public static boolean isApiParam(Parameter parameter) {

        Annotation[] annotations = parameter.getAnnotations();

        if (CollectionUtil.isEmpty(Arrays.asList(annotations))) {
            return false;
        }

        for (Annotation annotation : annotations) {

            if (annotation instanceof Param) {
                return true;
            }
        }
        return false;
    }

    public static boolean isApiResult(Class clazz) {

        Annotation[] annotations = clazz.getAnnotations();

        if (CollectionUtil.isNotEmpty(Arrays.asList(annotations))) {
            for (Annotation annotation : annotations) {

                if (annotation instanceof Result) {
                    return true;
                }
            }
        }

        if (clazz.equals(java.lang.Integer.class) ||
                clazz.equals(java.lang.Byte.class) ||
                clazz.equals(java.lang.Long.class) ||
                clazz.equals(java.lang.Double.class) ||
                clazz.equals(java.lang.Float.class) ||
                clazz.equals(java.lang.Character.class) ||
                clazz.equals(java.lang.Short.class) ||
                clazz.equals(java.lang.Boolean.class)) {
            return true;
        }

        if (clazz.getName().equals("int") ||
                clazz.getName().equals("byte") ||
                clazz.getName().equals("long") ||
                clazz.getName().equals("double") ||
                clazz.getName().equals("float") ||
                clazz.getName().equals("char") ||
                clazz.getName().equals("short") ||
                clazz.getName().equals("boolean")) {
            return true;
        }

        return false;
    }

    public static boolean isApiClassAnnotation(Annotation annotation) {

        return annotation instanceof Api;
    }

    public static boolean isApiMethodAnnotation(Annotation annotation) {

        return annotation instanceof Action;
    }

    public static boolean isApiParamAnnotation(Annotation annotation) {

        return annotation instanceof Param;
    }

    public static boolean isApiResultAnnotation(Annotation annotation) {

        return annotation instanceof Result;
    }
}
