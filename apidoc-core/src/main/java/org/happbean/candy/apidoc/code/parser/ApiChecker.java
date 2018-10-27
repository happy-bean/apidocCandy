package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.factory.annotation.Api;
import org.happbean.candy.apidoc.factory.annotation.request.Action;
import org.happbean.candy.apidoc.factory.annotation.request.Param;
import org.happbean.candy.apidoc.factory.annotation.response.Result;
import org.happbean.candy.apidoc.util.CollectionUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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

    public static boolean isApiParam(Class clazz){

        Annotation[] annotations = clazz.getAnnotations();

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

    public static boolean isApiResult(Class clazz){

        Annotation[] annotations = clazz.getAnnotations();

        if (CollectionUtil.isEmpty(Arrays.asList(annotations))) {
            return false;
        }

        for (Annotation annotation : annotations) {

            if (annotation instanceof Result) {
                return true;
            }
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
