package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.config.xml.elements.Property;
import org.happbean.candy.apidoc.internal.system.JavaSystem;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgt
 * @date 2018-10-26
 * @description
 **/
public class ApiClassParser {

    public static final Method[] getApiMethods(Class clazz) {

        Method[] methods = JavaClassParser.getMethods(clazz);

        methods = Arrays.stream(methods)
                .filter(method -> ApiChecker.isApiMethod(method)).toArray(Method[]::new);

        return methods;
    }

    public static final Parameter[] getApiParams(Method method) {

        Parameter[] parameters = JavaClassParser.getParamsClass(method);

        parameters = Arrays.stream(parameters)
                .filter(clazz -> ApiChecker.isApiParam(clazz)).toArray(Parameter[]::new);

        return parameters;
    }

    public static final Field[] getFields(Class clazz) {

        Field[] fields = clazz.getDeclaredFields();

        return fields;
    }

    public static final Class getApiReponse(Method method) {

        Class reponseClass = JavaClassParser.getReponseClass(method);

        return ApiChecker.isApiResult(reponseClass) ? reponseClass : null;
    }

    public static final String getClassApiType(Class clazz) {

        List<Property> properties = JavaSystem.JAVA_TYPE_RESOLVER.getProperties();

        for (Property property : properties) {
            if (clazz.getName().endsWith(property.getJavaType())) {
                return property.getApiType();
            }
        }
        String[] strs = clazz.getName().split("\\.");
        String apiTypeName = strs[strs.length - 1];
        return apiTypeName;
    }
}
