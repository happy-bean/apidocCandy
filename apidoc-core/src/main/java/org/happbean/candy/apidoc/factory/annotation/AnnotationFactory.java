package org.happbean.candy.apidoc.factory.annotation;

import org.happbean.candy.apidoc.factory.enums.AnnotationEnums;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wgt
 * @date 2018-09-18
 * @description
 **/
public class AnnotationFactory {

    public List<Class> getAnnotations() {

        List<Class> annotations = convertAnnotationEnums();

        return annotations;
    }


    private List<Class> convertAnnotationEnums() {

        AnnotationEnums[] annotationEnums = AnnotationEnums.values();

        List<Class> annotations
                = Arrays.stream(annotationEnums)
                .map(annotationEnum -> annotationEnum.getClazz()).collect(Collectors.toList());

        return annotations;
    }
}
