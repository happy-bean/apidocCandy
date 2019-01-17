package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.code.PackageScanner;
import org.happbean.candy.apidoc.internal.annotation.request.Action;
import org.happbean.candy.apidoc.internal.annotation.request.Param;
import org.happbean.candy.apidoc.internal.annotation.response.Result;
import org.happbean.candy.apidoc.internal.db.SqlExecuter;
import org.happbean.candy.apidoc.internal.db.dos.ApiDbObject;
import org.happbean.candy.apidoc.internal.factory.ApiSqlExecuterFactory;
import org.happbean.candy.apidoc.internal.system.ApiSqlSystem;
import org.happbean.candy.apidoc.internal.system.JavaSystem;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgt
 * @date 2018-10-25
 * @description
 **/
public class JavaFileParser {

    public static void parse() {

        List<Class<?>> apiClasses = PackageScanner.getApiClasses(JavaSystem.JAVA_SOURCE.getPackage());

        apiClasses.stream().forEach(clazz -> {
            parseClass(clazz);
        });
    }

    private static void parseClass(Class clazz) {
        Method[] methods = ApiClassParser.getApiMethods(clazz);

        Arrays.stream(methods).forEach(method -> {
            parseMethod(method);
        });
    }

    private static void parseMethod(Method method) {
        Annotation annotation = ApiAnnoParser.getApiMethodAnnotation(method);

        org.happbean.candy.apidoc.internal.db.dos.Action action = ApiSqlSystem.initAction((Action) annotation);

        Object actionId = excuteSql(action);

        Parameter[] parameters = ApiClassParser.getApiParams(method);
        long parameterId = -1;

        Object[] params = new Object[2];
        params[0] = actionId;

        for (Parameter parameter : parameters) {
            params[1] = parameterId;
            parameterId = parseParameter(parameter, params);
        }

        Class reponse = ApiClassParser.getApiReponse(method);

        parseReponse(reponse, params);
    }

    private static long parseParameter(Parameter parameter, Object[] params) {
        Annotation annotation = ApiAnnoParser.getApiParamAnnotation(parameter);
        org.happbean.candy.apidoc.internal.db.dos.Param param = ApiSqlSystem.initParam((Param) annotation);
        param.setActionId((long) params[0]);
        param.setLastId((long) params[1]);
        String classApiType = ApiClassParser.getClassApiType(parameter.getType());
        param.setType(classApiType);
        return (long) excuteSql(param);
    }

    private static void parseReponse(Class clazz, Object[] params) {
        Annotation annotation = ApiAnnoParser.getApiClassAnnotation(clazz);
        org.happbean.candy.apidoc.internal.db.dos.Result result = ApiSqlSystem.initResult((Result) annotation);
        result.setActionId((long) params[0]);
        String classApiType = ApiClassParser.getClassApiType(clazz);
        result.setType(classApiType);
        excuteSql(result);
    }

    private static Object excuteSql(ApiDbObject object) {
        SqlExecuter apiSqlExecuter = ApiSqlExecuterFactory.getApiSqlExecuter(object);

        Object result = null;
        try {
            if (apiSqlExecuter != null) {
                result = apiSqlExecuter.excute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
