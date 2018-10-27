package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.code.PackageScanner;
import org.happbean.candy.apidoc.internal.factory.ObjectFactory;
import org.happbean.candy.apidoc.util.CollectionUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            method.setAccessible(true);
            Parameter[] parameters = method.getParameters();
            for (int j = 0; j < parameters.length; j++) {
                Parameter parameter = parameters[j];
                Annotation[] annotations = parameter.getDeclaredAnnotations();
                for (int k = 0; k < annotations.length; k++) {
                    Annotation annotation = annotations[k];
                    System.out.println(parameter + ":" + annotation);
                }
            }
        }
        System.out.println("-------------------------------------");
    }
}
