package org.happbean.candy.apidoc.internal.sql;

import org.happbean.candy.apidoc.internal.db.dos.*;
import org.happbean.candy.apidoc.internal.factory.ApiSqlFactory;
import org.happbean.candy.apidoc.internal.sql.sqlpo.ApiSqlPoValueParser;
import org.happbean.candy.apidoc.internal.sql.sqlpo.SqlPoValueParser;
import org.happbean.candy.apidoc.internal.sql.sqlpo.Table;
import org.happbean.candy.apidoc.internal.sql.sqlpo.Value;
import org.happbean.candy.apidoc.internal.system.DbEnums;
import org.happbean.candy.apidoc.internal.system.DbSystem;

import java.util.List;

/**
 * @author wgt
 * @date 2018-11-06
 * @description
 **/
public class ApiSqlBuilder {

    private static SqlBuilder<Table, List<Value>> sqlBuilder = new DefaultSqlBuilder(ApiSqlFactory.getInstance());

    private ApiDbObject object = null;

    public ApiSqlBuilder(ApiDbObject object) {

        this.object = object;
    }

    public String buildSelectSql() {

        SqlPoValueParser valueParser = ApiSqlPoValueParser.getSqlPoValueParser(this.object);

        List<Value> values = valueParser.parseValue();

        String sql = sqlBuilder.buildSelect(getTable(), values);

        return sql;
    }

    public String buildInsertSql() {

        SqlPoValueParser valueParser = ApiSqlPoValueParser.getSqlPoValueParser(object);

        List<Value> values = valueParser.parseValue();

        String sql = sqlBuilder.buildInsert(getTable(), values);

        return sql;
    }

    public String buildUpdateSql() {

        SqlPoValueParser valueParser = ApiSqlPoValueParser.getSqlPoValueParser(object);

        List<Value> values = valueParser.parseValue();

        String sql = sqlBuilder.buildUpdate(getTable(), values);

        return sql;
    }

    public String buildDeleteSql() {

        SqlPoValueParser valueParser = ApiSqlPoValueParser.getSqlPoValueParser(object);

        List<Value> values = valueParser.parseValue();

        String sql = sqlBuilder.buildDelete(getTable(), values);

        return sql;
    }

    private Table getTable() {

        Table table = new Table();

        if (this.object instanceof Action) {
            org.happbean.candy.apidoc.config.xml.elements.Table table1 = DbSystem.TABLES.get(DbEnums.TableName.ACTION);
            table.setTableName(table1.getTableName());
            table.setColumns(table1.getColumns());
        } else if (this.object instanceof Param) {

            org.happbean.candy.apidoc.config.xml.elements.Table table1 = DbSystem.TABLES.get(DbEnums.TableName.PARAM);
            table.setTableName(table1.getTableName());
            table.setColumns(table1.getColumns());
        } else if (this.object instanceof Header) {

            org.happbean.candy.apidoc.config.xml.elements.Table table1 = DbSystem.TABLES.get(DbEnums.TableName.HEADER);
            table.setTableName(table1.getTableName());
            table.setColumns(table1.getColumns());
        } else if (this.object instanceof Result) {

            org.happbean.candy.apidoc.config.xml.elements.Table table1 = DbSystem.TABLES.get(DbEnums.TableName.RESULT);
            table.setTableName(table1.getTableName());
            table.setColumns(table1.getColumns());
        }

        return table;
    }
}
