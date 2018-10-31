package org.happbean.candy.apidoc.code.parser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author wgt
 * @date 2018-09-17
 * @description
 **/
public class AnnotationParser {

    public static final Annotation[] getClassAnnotations(Class clazz) {

        if (clazz == null) {
            return null;
        }

        Annotation[] annotations = clazz.getAnnotations();

        return annotations;
    }

    public static final Annotation[] getMethodAnnotations(Method method) {

        if (method == null) {
            return null;
        }

        Annotation[] annotations = method.getAnnotations();

        return annotations;
    }

    private static final Annotation[] getFieldAnnotations(Field field) {

        if (field == null) {
            return null;
        }

        if (!field.isAccessible()) {
            field.setAccessible(true);
        }

        Annotation[] annotations = field.getAnnotations();

        return annotations;
    }

    public static final Annotation[] getParamFieldAnnotations(Field field) {

        if (field == null) {
            return null;
        }

        Annotation[] annotations = getFieldAnnotations(field);

        return annotations;
    }

    public static final Annotation[] getResultFieldAnnotations(Field field) {

        if (field == null) {
            return null;
        }

        Annotation[] annotations = getFieldAnnotations(field);

        return annotations;
    }

    public static final Annotation[] getParamAnnotations(Parameter parameter) {

        if (parameter == null) {
            return null;
        }

        Annotation[] annotations = parameter.getDeclaredAnnotations();

        return annotations;
    }
}
