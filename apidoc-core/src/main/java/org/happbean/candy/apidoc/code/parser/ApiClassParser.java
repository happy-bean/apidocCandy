package org.happbean.candy.apidoc.code.parser;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

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

    public static final Class getApiReponse(Method method) {

        Class reponseClass = JavaClassParser.getReponseClass(method);

        return ApiChecker.isApiResult(reponseClass) ? reponseClass : null;
    }
}
