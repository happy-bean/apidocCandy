package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.code.PackageScanner;
import org.happbean.candy.apidoc.internal.factory.ObjectFactory;
import org.happbean.candy.apidoc.util.CollectionUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgt
 * @date 2018-09-20
 * @description
 **/
public class FileParser {

    public static void parse(String packagePath) {

    }

    public static void main(String[] args) throws ClassNotFoundException {

        Class clazz = ObjectFactory.externalClassForName("org.happbean.candy.apidoc.demo.UserController");

        System.out.println("-------------------------------------");

        Method[] methods = clazz.getMethods();

        parseMethod(methods[1]);
//        for (int i = 0; i < methods.length; i++) {
//            Method method = methods[i];
//            method.setAccessible(true);
//            Parameter[] parameters = method.getParameters();
//            for (int j = 0; j < parameters.length; j++) {
//                Parameter parameter = parameters[j];
//                Annotation[] annotations = parameter.getDeclaredAnnotations();
//                for (int k = 0; k < annotations.length; k++) {
//                    Annotation annotation = annotations[k];
//                    System.out.println(parameter + ":" + annotation);
//                }
//            }
//        }
        System.out.println("-------------------------------------");
    }

    public static void parseMethod(Method method) {
        //解析方法注解
        Annotation[] methodAnnotations = AnnotationParser.getMethodAnnotations(method);
        Parser parser = ApiParser.getParser(methodAnnotations[0]);
        parser.parseValue();

        //解析参数注解
        Parameter[] apiParamsClass = ApiClassParser.getApiParams(method);
        parseParams(apiParamsClass);

    }

    public static void parseParams(Parameter[] parameters) {
        Arrays.stream(parameters).forEach(parameter -> {
            parseParam(parameter);
        });
    }

    public static  void parseResult(Class clazz){

    }

    public static void parseParam(Parameter parameter) {

        Annotation[] annotations = parameter.getDeclaredAnnotations();
        Parser parser = ApiParser.getParser(annotations[0]);
        parser.parseValue();

        if (!isJavaClass(parameter.getType())) {
            parseParamFileds(parameter.getType().getDeclaredFields());
        }
    }

    public static boolean isJavaClass(Class<?> clz) {
        return clz != null && clz.getClassLoader() == null;
    }

    public static void parseParamFileds(final Field[] fields) {
        Arrays.stream(fields).forEach(field -> {
            parseParamFiled(field);
            if (!isJavaClass(field.getType())) {
                parseParamFileds(field.getType().getDeclaredFields());
            }
        });
    }

    public static void parseParamFiled(final Field field) {
        Annotation[] fieldAnnotations = AnnotationParser.getParamFieldAnnotations(field);

        if(CollectionUtil.isEmpty(Arrays.asList(fieldAnnotations))){
            return;
        }
        Parser parser = ApiParser.getParser(fieldAnnotations[0]);
        parser.parseValue();
    }
}
