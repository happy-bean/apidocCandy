package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.factory.annotation.Api;

import java.lang.annotation.Annotation;

/**
 * @author wgt
 * @date 2018-09-17
 * @description
 **/
public class AnnotationParser {

    public static boolean checkApiAnnotation(Class clazz) {

        Annotation annotation = clazz.getAnnotation(Api.class);

        return annotation == null ? false : true;
    }
}
