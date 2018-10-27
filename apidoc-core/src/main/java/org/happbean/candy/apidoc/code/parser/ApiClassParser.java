package org.happbean.candy.apidoc.code.parser;

import java.lang.reflect.Method;
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

    public static final Class[] getApiParamsClass(Method method) {

        Class[] paramsClass = JavaClassParser.getParamsClass(method);

        paramsClass = Arrays.stream(paramsClass)
                .filter(clazz -> ApiChecker.isApiParam(clazz)).toArray(Class[]::new);

        return paramsClass;
    }

    public static final Class getApiReponseClass(Method method) {

        Class reponseClass = JavaClassParser.getReponseClass(method);

        return ApiChecker.isApiResult(reponseClass) ? reponseClass : null;
    }
}
