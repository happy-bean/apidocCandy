package org.happbean.candy.apidoc.internal.sql.sqlpo;

import org.happbean.candy.apidoc.config.xml.elements.Column;
import org.happbean.candy.apidoc.internal.annotation.request.Action;
import org.happbean.candy.apidoc.internal.annotation.request.Header;
import org.happbean.candy.apidoc.internal.annotation.request.Param;
import org.happbean.candy.apidoc.internal.annotation.response.Result;
import org.happbean.candy.apidoc.internal.system.DbEnums;
import org.happbean.candy.apidoc.internal.system.DbSystem;
import org.happbean.candy.apidoc.util.CollectionUtil;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wgt
 * @date 2018-11-06
 * @description
 **/
public class ApiSqlPoValueParser {

    public static SqlPoValueParser getSqlPoValueParser(Annotation annotation) {

        SqlPoValueParser parser = null;

        if (annotation instanceof Action) {
            parser = getActionSqlPoValueParser((Action) annotation);
        } else if (annotation instanceof Param) {
            parser = getParamSqlPoValueParser((Param) annotation);
        } else if (annotation instanceof Header) {
            parser = getHeaderSqlPoValueParser((Header) annotation);
        } else if (annotation instanceof Result) {
            parser = getResultSqlPoValueParser((Result) annotation);
        }

        return parser;
    }

    private static Map<String, List<Column>> getColumns(String tableName) {

        List<Column> columns = DbSystem.TABLES.get(tableName).getColumns();

        if (CollectionUtil.isEmpty(columns)) {
            //throw
        }

        Map<String, List<Column>> collect = columns.stream().collect(Collectors.groupingBy(Column::getProperty));

        return collect;
    }

    private static SqlPoValueParser getActionSqlPoValueParser(Action action) {

        SqlPoValueParser parser = () -> {

            List<Value> values = new ArrayList<>();

            Map<String, List<Column>> columns = getColumns(DbEnums.TableName.ACTION);

            values.add(new Value(columns.get(DbEnums.Column.NAME).get(0).getProperty(), action.name()));

            values.add(new Value(columns.get(DbEnums.Column.PATH).get(0).getProperty(), action.path()));

            values.add(new Value(columns.get(DbEnums.Column.DESC).get(0).getProperty(), action.desc()));

            return values;
        };

        return parser;
    }

    private static SqlPoValueParser getParamSqlPoValueParser(Param param) {

        SqlPoValueParser parser = () -> {

            List<Value> values = new ArrayList<>();

            Map<String, List<Column>> columns = getColumns(DbEnums.TableName.PARAM);

            values.add(new Value(columns.get(DbEnums.Column.NAME).get(0).getProperty(), param.name()));

            values.add(new Value(columns.get(DbEnums.Column.REQUIRED).get(0).getProperty(), String.valueOf(param.required())));

            values.add(new Value(columns.get(DbEnums.Column.DESC).get(0).getProperty(), param.desc()));

            return values;
        };

        return parser;
    }

    private static SqlPoValueParser getHeaderSqlPoValueParser(Header header) {

        SqlPoValueParser parser = () -> {

            List<Value> values = new ArrayList<>();

            Map<String, List<Column>> columns = getColumns(DbEnums.TableName.RESULT);

            values.add(new Value(columns.get(DbEnums.Column.NAME).get(0).getProperty(), header.name()));

            values.add(new Value(columns.get(DbEnums.Column.VALUE).get(0).getProperty(), header.value()));

            values.add(new Value(columns.get(DbEnums.Column.REQUIRED).get(0).getProperty(), String.valueOf(header.required())));

            values.add(new Value(columns.get(DbEnums.Column.DESC).get(0).getProperty(), header.desc()));

            return values;
        };

        return parser;
    }

    private static SqlPoValueParser getResultSqlPoValueParser(Result result) {

        SqlPoValueParser parser = () -> {

            List<Value> values = new ArrayList<>();

            Map<String, List<Column>> columns = getColumns(DbEnums.TableName.RESULT);

            values.add(new Value(columns.get(DbEnums.Column.NAME).get(0).getProperty(), result.name()));

            values.add(new Value(columns.get(DbEnums.Column.VALUE).get(0).getProperty(), result.value()));

            values.add(new Value(columns.get(DbEnums.Column.DESC).get(0).getProperty(), result.desc()));

            return values;
        };

        return parser;
    }
}
