package org.happbean.candy.apidoc.internal.sql.sqlpo;

import org.happbean.candy.apidoc.config.xml.elements.Column;
import org.happbean.candy.apidoc.internal.db.dos.*;
import org.happbean.candy.apidoc.internal.system.DbEnums;
import org.happbean.candy.apidoc.internal.system.DbSystem;
import org.happbean.candy.apidoc.util.CollectionUtil;

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

    public static SqlPoValueParser getSqlPoValueParser(ApiDbObject object) {

        SqlPoValueParser parser = null;

        if (object instanceof Action) {
            parser = getActionSqlPoValueParser((Action) object);
        } else if (object instanceof Param) {
            parser = getParamSqlPoValueParser((Param) object);
        } else if (object instanceof Header) {
            parser = getHeaderSqlPoValueParser((Header) object);
        } else if (object instanceof Result) {
            parser = getResultSqlPoValueParser((Result) object);
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

            values.add(new Value(columns.get(DbEnums.Column.NAME).get(0).getValue(), action.getName()));

            values.add(new Value(columns.get(DbEnums.Column.PATH).get(0).getValue(), action.getPath()));

            values.add(new Value(columns.get(DbEnums.Column.DESC).get(0).getValue(), action.getDesc()));

            values.add(new Value(columns.get(DbEnums.Column.METHOD).get(0).getValue(), action.getMethod()));

            return values;
        };

        return parser;
    }

    private static SqlPoValueParser getParamSqlPoValueParser(Param param) {

        SqlPoValueParser parser = () -> {

            List<Value> values = new ArrayList<>();

            Map<String, List<Column>> columns = getColumns(DbEnums.TableName.PARAM);

            values.add(new Value(columns.get(DbEnums.Column.ACTION_ID).get(0).getValue(), String.valueOf(param.getActionId())));

            values.add(new Value(columns.get(DbEnums.Column.NAME).get(0).getValue(), param.getName()));

            values.add(new Value(columns.get(DbEnums.Column.TYPE).get(0).getValue(), param.getType()));

            values.add(new Value(columns.get(DbEnums.Column.REQUIRED).get(0).getValue(), param.getRequired()));

            values.add(new Value(columns.get(DbEnums.Column.DESC).get(0).getValue(), param.getDesc()));

            values.add(new Value(columns.get(DbEnums.Column.LAST_ID).get(0).getValue(), String.valueOf(param.getLastId())));

            return values;
        };

        return parser;
    }

    private static SqlPoValueParser getHeaderSqlPoValueParser(Header header) {

        SqlPoValueParser parser = () -> {

            List<Value> values = new ArrayList<>();

            Map<String, List<Column>> columns = getColumns(DbEnums.TableName.HEADER);

            values.add(new Value(columns.get(DbEnums.Column.ACTION_ID).get(0).getValue(), String.valueOf(header.getActionId())));

            values.add(new Value(columns.get(DbEnums.Column.NAME).get(0).getValue(), header.getName()));

            values.add(new Value(columns.get(DbEnums.Column.REQUIRED).get(0).getValue(), header.getRequired()));

            values.add(new Value(columns.get(DbEnums.Column.DESC).get(0).getValue(), header.getDesc()));

            return values;
        };

        return parser;
    }

    private static SqlPoValueParser getResultSqlPoValueParser(Result result) {

        SqlPoValueParser parser = () -> {

            List<Value> values = new ArrayList<>();

            Map<String, List<Column>> columns = getColumns(DbEnums.TableName.RESULT);

            values.add(new Value(columns.get(DbEnums.Column.ACTION_ID).get(0).getValue(), String.valueOf(result.getActionId())));

            values.add(new Value(columns.get(DbEnums.Column.NAME).get(0).getValue(), result.getName()));

            values.add(new Value(columns.get(DbEnums.Column.TYPE).get(0).getValue(), result.getType()));

            values.add(new Value(columns.get(DbEnums.Column.VALUE).get(0).getValue(), result.getValue()));

            values.add(new Value(columns.get(DbEnums.Column.DESC).get(0).getValue(), result.getDesc()));

            values.add(new Value(columns.get(DbEnums.Column.LAST_ID).get(0).getValue(), String.valueOf(result.getLastId())));

            return values;
        };

        return parser;
    }
}
