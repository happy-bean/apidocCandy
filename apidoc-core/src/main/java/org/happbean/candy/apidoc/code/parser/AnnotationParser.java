package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.factory.AnnotationFactory;
import org.happbean.candy.apidoc.util.CollectionUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author wgt
 * @date 2018-09-17
 * @description
 **/
public class AnnotationParser {

    public static boolean checkMethodAnnotation(Method method) {

        Annotation[] annotations = method.getAnnotations();

        annotations = Arrays.stream(annotations)
                .filter(annotation -> checkAnnotation(annotation)).toArray(Annotation[]::new);

        return annotations.length == 0 ? false : true;
    }

    public static boolean checkAnnotation(Annotation annotation) {

        List<Class> annotations = AnnotationFactory.getAnnotations();

        return (annotation != null && annotations.contains(annotation.annotationType()));
    }

    public static final Annotation[] getClassAnnotations(Class clazz) {

        Annotation[] annotations = clazz.getAnnotations();

        if (CollectionUtil.isEmpty(Arrays.asList(annotations))) {
            return null;
        }

        annotations = Arrays.stream(annotations)
                .filter(annotation -> checkAnnotation(annotation)).toArray(Annotation[]::new);

        return annotations;
    }

    public static final Annotation[] getApiClassAnnotations(Class clazz) {

        return getClassAnnotations(clazz);
    }

    public static final Map<String, Annotation[]> getFieldAnnotations(Class clazz) {

        Field[] fields = clazz.getDeclaredFields();

        if (CollectionUtil.isEmpty(Arrays.asList(fields))) {
            return null;
        }

        Map<String, Annotation[]> annotationMap = new HashMap<>();

        Arrays.stream(fields).forEach(field -> {

            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            Annotation[] annotations = field.getAnnotations();

            annotations = Arrays.stream(annotations)
                    .filter(annotation -> checkAnnotation(annotation)).toArray(Annotation[]::new);

            annotationMap.put(field.getName(), annotations);
        });

        return annotationMap;
    }

    public static final Map<String, Annotation[]> getMethodAnnotations(Class clazz) {

        Method[] methods = clazz.getMethods();

        if (methods == null) {
            return null;
        }

        methods = Arrays.stream(methods)
                .filter(method -> ApiChecker.isApiMethod(method)).toArray(Method[]::new);

        Map<String, Annotation[]> annotationMap = new HashMap<>();

        Arrays.stream(methods).forEach(method -> {

            Annotation[] annotations = method.getAnnotations();

            annotations = Arrays.stream(annotations)
                    .filter(annotation -> checkAnnotation(annotation)).toArray(Annotation[]::new);

            annotationMap.put(method.toGenericString(), annotations);
        });

        return annotationMap;
    }

}
