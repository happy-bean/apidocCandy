package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.code.ReflectUtil;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Map;

/**
 * @author wgt
 * @date 2018-09-20
 * @description
 **/
public class CodeParser {

    public static void main(String[] args) {

        Class clazz = ReflectUtil.getClassForName("org.happbean.candy.apidoc.demo.UserController");

        //先判断是不是 api class
        if (!AnnotationParser.isApiClass(clazz)) {
            return;
        }

        JavaClassParser classParser = new JavaClassParser(clazz);

        Annotation[] annotationsClass = AnnotationParser.getApiClassAnnotations(clazz);

        Arrays.stream(annotationsClass).forEach(annotation -> {
            AnnoValueParser annoValueParser = new AnnoValueParser(annotation);
            annoValueParser.parseAnnoValue();
        });

        Map<String, Class[]> paramsClassMap = classParser.getParamsClass();

        paramsClassMap.forEach((key, values) -> {

            Arrays.stream(values).forEach(value -> {
                Annotation[] annotationsResp = AnnotationParser.getApiClassAnnotations(value);

                Arrays.stream(annotationsResp).forEach(annotation -> {
                    AnnoValueParser annoValueParser = new AnnoValueParser(annotation);
                    annoValueParser.parseAnnoValue();
                });
            });

        });

        Map<String, Class> respClassMap = classParser.getReponseClass();

        respClassMap.forEach((key, value) -> {

            Annotation[] annotationsResp = AnnotationParser.getApiClassAnnotations(value);

            Arrays.stream(annotationsResp).forEach(annotation -> {
                AnnoValueParser annoValueParser = new AnnoValueParser(annotation);
                annoValueParser.parseAnnoValue();
            });
        });
    }
}
