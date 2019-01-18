package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.code.PackageScanner;
import org.happbean.candy.apidoc.internal.annotation.request.Action;
import org.happbean.candy.apidoc.internal.annotation.request.Header;
import org.happbean.candy.apidoc.internal.annotation.request.Param;
import org.happbean.candy.apidoc.internal.annotation.response.Result;
import org.happbean.candy.apidoc.internal.db.SqlExecuter;
import org.happbean.candy.apidoc.internal.db.dos.ApiDbObject;
import org.happbean.candy.apidoc.internal.factory.ApiSqlExecuterFactory;
import org.happbean.candy.apidoc.internal.factory.ConnectionFactory;
import org.happbean.candy.apidoc.internal.system.ApiSqlSystem;
import org.happbean.candy.apidoc.internal.system.JavaSystem;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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

        ConnectionFactory.closeConnection();
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

        Action action1 = (Action) annotation;

        Object[] params = new Object[2];
        params[0] = actionId;
        params[1] = -1L;

        Header[] headers = action1.headers();
        Arrays.stream(headers).forEach(header -> {
            parseHeader(header, params);
        });

        Parameter[] parameters = ApiClassParser.getApiParams(method);

        for (Parameter parameter : parameters) {
            parseParameter(parameter, params);
        }
        params[1] = -1L;
        Class reponse = ApiClassParser.getApiReponse(method);

        parseReponse(reponse, params);
    }

    private static long parseHeader(Header header, Object[] params) {
        org.happbean.candy.apidoc.internal.db.dos.Header header1 = ApiSqlSystem.initHeader(header);
        header1.setActionId((long) params[0]);
        long headerId = (long) excuteSql(header1);
        return headerId;
    }

    private static long parseParameter(Parameter parameter, Object[] params) {
        Annotation annotation = ApiAnnoParser.getApiParamAnnotation(parameter);
        org.happbean.candy.apidoc.internal.db.dos.Param param = ApiSqlSystem.initParam((Param) annotation);
        param.setActionId((long) params[0]);
        param.setLastId((long) params[1]);
        String classApiType = ApiClassParser.getClassApiType(parameter.getType());
        param.setType(classApiType);

        long parameterId = (long) excuteSql(param);

        Field[] fields = ApiClassParser.getFields(parameter.getType());
        Arrays.stream(fields).forEach(field -> {
            Annotation annotation1 = ApiAnnoParser.getApiParamFieldAnnotation(field);
            if (annotation1 != null) {
                org.happbean.candy.apidoc.internal.db.dos.Param param1 = ApiSqlSystem.initParam((Param) annotation1);
                param1.setActionId((long) params[0]);
                param1.setLastId(parameterId);
                String classApiType1 = ApiClassParser.getClassApiType(field.getType());
                param1.setType(classApiType1);
                excuteSql(param1);
            }
        });

        return parameterId;
    }

    private static void parseReponse(Class clazz, Object[] params) {
        Annotation annotation = ApiAnnoParser.getApiClassAnnotation(clazz);
        org.happbean.candy.apidoc.internal.db.dos.Result result = ApiSqlSystem.initResult((Result) annotation);
        result.setActionId((long) params[0]);
        result.setLastId((long) params[1]);
        String classApiType = ApiClassParser.getClassApiType(clazz);
        result.setType(classApiType);
        long resultId = (long) excuteSql(result);

        Field[] fields = ApiClassParser.getFields(clazz);
        Arrays.stream(fields).forEach(field -> {
            Annotation annotation1 = ApiAnnoParser.getApiResultFieldAnnotation(field);
            if (annotation1 != null) {
                org.happbean.candy.apidoc.internal.db.dos.Result result1 = ApiSqlSystem.initResult((Result) annotation1);
                result1.setActionId((long) params[0]);
                result1.setLastId(resultId);
                String classApiType1 = ApiClassParser.getClassApiType(field.getType());
                result1.setType(classApiType1);
                excuteSql(result1);
            }
        });
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
