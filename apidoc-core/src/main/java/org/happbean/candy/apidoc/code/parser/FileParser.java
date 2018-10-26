package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.code.PackageScanner;
import org.happbean.candy.apidoc.code.ReflectUtil;
import org.happbean.candy.apidoc.internal.factory.ObjectFactory;
import org.happbean.candy.apidoc.util.CollectionUtil;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author wgt
 * @date 2018-09-20
 * @description
 **/
public class FileParser {

    public static void parse(String packagePath) {

        List<Class<?>> classes = PackageScanner.getApiClasses(packagePath);

        if (CollectionUtil.isNotEmpty(classes)) {
            classes.stream().forEach(clazz -> {

                JavaClassParser classParser = new JavaClassParser(clazz);

                Annotation[] annotationsClass = AnnotationParser.getApiClassAnnotations(clazz);

            });
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        Class clazz = ObjectFactory.externalClassForName("org.happbean.candy.apidoc.demo.UserController");

        JavaClassParser classParser = new JavaClassParser(clazz);

        Map<String, Class[]> paramsClass = classParser.getParamsClass();

        final Map<String, Annotation[]> methodAnnotations = AnnotationParser.getMethodAnnotations(clazz);

        methodAnnotations.forEach((key, annotations) -> {
            System.out.println(key);
            Arrays.stream(annotations).forEach(annotation -> {
                AnnoValueParser parser = new AnnoValueParser(annotation);
                parser.parseAnnoValue();
            });
            if (paramsClass.containsKey(key)){
                Class[] classes = paramsClass.get(key);

            }
        });

        System.out.println("-------------------------------------");
    }
}
