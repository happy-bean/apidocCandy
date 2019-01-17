package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.internal.annotation.Api;
import org.happbean.candy.apidoc.internal.annotation.request.Action;
import org.happbean.candy.apidoc.internal.annotation.request.Param;
import org.happbean.candy.apidoc.internal.annotation.response.Result;
import org.happbean.candy.apidoc.util.ArrayUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @author wgt
 * @date 2018-10-29
 * @description
 **/
public class ApiAnnoParser {

    public static final Annotation getApiClassAnnotation(Class clazz) {

        if (clazz == null) {
            return null;
        }

        Annotation[] annotations = AnnotationParser.getClassAnnotations(clazz);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        annotations = Arrays.stream(annotations)
                .filter(annotation -> (annotation instanceof Api)).toArray(Annotation[]::new);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        return annotations[0];
    }

    public static final Annotation getApiMethodAnnotation(Method method) {

        if (method == null) {
            return null;
        }

        Annotation[] annotations = AnnotationParser.getMethodAnnotations(method);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        annotations = Arrays.stream(annotations)
                .filter(annotation -> (annotation instanceof Action)).toArray(Annotation[]::new);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        return annotations[0];
    }

    public static final Annotation getApiParamAnnotation(Parameter parameter) {

        if (parameter == null) {
            return null;
        }

        Annotation[] annotations = AnnotationParser.getParamAnnotations(parameter);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        annotations = Arrays.stream(annotations)
                .filter(annotation -> (annotation instanceof Param)).toArray(Annotation[]::new);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }
        return annotations[0];
    }

    public static final Annotation getApiParamFieldAnnotation(Field field) {

        if (field == null) {
            return null;
        }

        Annotation[] annotations = AnnotationParser.getParamFieldAnnotations(field);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        annotations = Arrays.stream(annotations)
                .filter(annotation -> (annotation instanceof Param)).toArray(Annotation[]::new);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        return annotations[0];
    }

    public static final Annotation[] getApiResultAnnotations(Method method) {

        if (method == null) {
            return null;
        }

        Annotation[] annotations = AnnotationParser.getResultAnnotations(method);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        annotations = Arrays.stream(annotations)
                .filter(annotation -> (annotation instanceof Result)).toArray(Annotation[]::new);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        return annotations;
    }

    public static final Annotation getApiResultFieldAnnotation(Field field) {

        if (field == null) {
            return null;
        }

        Annotation[] annotations = AnnotationParser.getResultFieldAnnotations(field);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        annotations = Arrays.stream(annotations)
                .filter(annotation -> (annotation instanceof Result)).toArray(Annotation[]::new);

        if (ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        return annotations[0];
    }

}
