package org.happbean.candy.apidoc.internal.sql;

import org.happbean.candy.apidoc.config.xml.xmlpo.Table;
import org.happbean.candy.apidoc.exception.SqlBuildException;
import org.happbean.candy.apidoc.internal.sql.sqlpo.Value;
import org.happbean.candy.apidoc.util.CollectionUtil;
import org.happbean.candy.apidoc.util.StringUtil;

import java.util.List;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public class ApiSqlFactory implements SqlFactory<Table, List<Value>> {

    @Override
    public String getInsertSql(Table table, List<Value> values) {
        tableCheck(table);
        valuesCheck(values);

        StringBuffer sql = new StringBuffer();

        sql.append(SqlRules.MYSQL.INSERT).append(table.getTableName());
        values.stream().forEach(value -> {
            sql.append(value.getColumnName()).append(SqlRules.MYSQL.COMMA);
        });
        sql.deleteCharAt(sql.length() - 1);

        sql.append(SqlRules.MYSQL.CLOSEBRACE).append(SqlRules.MYSQL.VALUE)
                .append(SqlRules.MYSQL.OPENBRACE);
        values.stream().forEach(value -> {
            sql.append(value.getColumnValue()).append(SqlRules.MYSQL.COMMA);
        });
        sql.deleteCharAt(sql.length() - 1);

        return sql.toString();
    }

    @Override
    public String getSelectSql(Table table, List<Value> values) {
        tableCheck(table);

        StringBuffer sql = new StringBuffer();
        sql.append(SqlRules.MYSQL.SELECT);
        table.getColumns().stream().forEach(column -> {
            sql.append(column.getValue()).append(SqlRules.MYSQL.COMMA);
        });
        sql.deleteCharAt(sql.length() - 1);

        if (CollectionUtil.isNotEmpty(values)) {
            sql.append(SqlRules.MYSQL.WHERE);
            values.stream().forEach(value -> {
                sql.append(value.getColumnName()).append(SqlRules.MYSQL.EQUALSSIGN)
                        .append(value.getColumnValue()).append(SqlRules.MYSQL.COMMA);
            });
        }
        sql.deleteCharAt(sql.length() - 1);

        return sql.toString();
    }

    @Override
    public String getDeleteSql(Table table, List<Value> values) {
        tableCheck(table);
        valuesCheck(values);

        StringBuffer sql = new StringBuffer();
        sql.append(SqlRules.MYSQL.DELETE).append(SqlRules.MYSQL.FROM)
                .append(table.getTableName()).append(SqlRules.MYSQL.WHERE);

        values.stream().forEach(value -> {
            sql.append(value.getColumnName()).append(SqlRules.MYSQL.EQUALSSIGN)
                    .append(value.getColumnValue()).append(SqlRules.MYSQL.AND);
        });
        sql.deleteCharAt(sql.length() - 4);

        return sql.toString();
    }

    @Override
    public String getUpdateSql(Table table, List<Value> values) {
        tableCheck(table);
        valuesCheck(values);

        StringBuffer sql = new StringBuffer();
        sql.append(SqlRules.MYSQL.UPDATE).append(table.getTableName())
                .append(SqlRules.MYSQL.SET);
        values.stream().forEach(value -> {
            sql.append(value.getColumnName()).append(SqlRules.MYSQL.EQUALSSIGN)
                    .append(value.getColumnValue()).append(SqlRules.MYSQL.COMMA);
        });
        sql.deleteCharAt(sql.length() - 1);

        return sql.toString();
    }

    private void tableCheck(Table table) {

        if (table == null || StringUtil.isBlank(table.getTableName())) {
            throw new SqlBuildException("");
        }
    }

    private void valuesCheck(List<Value> values) {

        if (CollectionUtil.isEmpty(values)) {
            throw new SqlBuildException("");
        }
    }
}
