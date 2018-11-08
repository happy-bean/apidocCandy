package org.happbean.candy.apidoc.internal.sql;

import org.happbean.candy.apidoc.factory.annotation.request.Action;
import org.happbean.candy.apidoc.factory.annotation.request.Header;
import org.happbean.candy.apidoc.factory.annotation.request.Param;
import org.happbean.candy.apidoc.factory.annotation.response.Result;
import org.happbean.candy.apidoc.internal.factory.ApiSqlFactory;
import org.happbean.candy.apidoc.internal.sql.sqlpo.ApiSqlPoValueParser;
import org.happbean.candy.apidoc.internal.sql.sqlpo.SqlPoValueParser;
import org.happbean.candy.apidoc.internal.sql.sqlpo.Table;
import org.happbean.candy.apidoc.internal.sql.sqlpo.Value;
import org.happbean.candy.apidoc.internal.system.DbEnums;
import org.happbean.candy.apidoc.internal.system.DbSystem;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author wgt
 * @date 2018-11-06
 * @description
 **/
public class ApiSqlBuilder {

    private static SqlBuilder<Table, List<Value>> sqlBuilder = new DefaultSqlBuilder(ApiSqlFactory.getInstance());

    private Annotation annotation = null;

    public ApiSqlBuilder(Annotation annotation) {

        this.annotation = annotation;
    }

    public String buildSelectSql() {

        SqlPoValueParser valueParser = ApiSqlPoValueParser.getSqlPoValueParser(this.annotation);

        List<Value> values = valueParser.parseValue();

        String sql = sqlBuilder.buildSelect(getTableName(), values);

        return sql;
    }

    public String buildInsertSql() {

        SqlPoValueParser valueParser = ApiSqlPoValueParser.getSqlPoValueParser(this.annotation);

        List<Value> values = valueParser.parseValue();

        String sql = sqlBuilder.buildInsert(getTableName(), values);

        return sql;
    }

    public String buildUpdateSql() {

        SqlPoValueParser valueParser = ApiSqlPoValueParser.getSqlPoValueParser(this.annotation);

        List<Value> values = valueParser.parseValue();

        String sql = sqlBuilder.buildUpdate(getTableName(), values);

        return sql;
    }

    public String buildDeleteSql() {

        SqlPoValueParser valueParser = ApiSqlPoValueParser.getSqlPoValueParser(this.annotation);

        List<Value> values = valueParser.parseValue();

        String sql = sqlBuilder.buildDelete(getTableName(), values);

        return sql;
    }

    private Table getTableName() {

        Table table = new Table();

        String tableName = null;

        if (this.annotation instanceof Action) {
            tableName = DbSystem.TABLES.get(DbEnums.TableName.ACTION).getTableName();
        } else if (this.annotation instanceof Param) {

            tableName = DbSystem.TABLES.get(DbEnums.TableName.PARAM).getTableName();
        } else if (this.annotation instanceof Header) {

            tableName = DbSystem.TABLES.get(DbEnums.TableName.HEADER).getTableName();
        } else if (this.annotation instanceof Result) {

            tableName = DbSystem.TABLES.get(DbEnums.TableName.RESULT).getTableName();
        }

        table.setTableName(tableName);

        return table;
    }
}
