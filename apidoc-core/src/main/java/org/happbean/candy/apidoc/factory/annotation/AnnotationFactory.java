package org.happbean.candy.apidoc.factory.annotation;

import org.happbean.candy.apidoc.factory.enums.AnnotationEnums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wgt
 * @date 2018-09-18
 * @description
 **/
public class AnnotationFactory {

    private volatile static List<Class> annotations;

    public static List<Class> getAnnotations() {

        if (annotations == null) {
            synchronized (AnnotationFactory.class) {
                if (annotations == null) {
                    annotations = convertAnnotationEnums();
                }
            }
        }
        return annotations;
    }

    private static List<Class> convertAnnotationEnums() {

        AnnotationEnums[] annotationEnums = AnnotationEnums.values();
        List<Class> annotations
                = Arrays.stream(annotationEnums)
                .map(annotationEnum -> annotationEnum.getClazz()).collect(Collectors.toList());
        return annotations;
    }
}
