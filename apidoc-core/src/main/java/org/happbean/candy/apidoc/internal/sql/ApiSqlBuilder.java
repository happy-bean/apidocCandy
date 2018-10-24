package org.happbean.candy.apidoc.internal.sql;

import org.happbean.candy.apidoc.config.xml.xmlpo.Table;
import org.happbean.candy.apidoc.internal.sql.sqlpo.Value;

import java.util.List;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public class ApiSqlBuilder extends SqlBuilder<Table, List<Value>> {

    public ApiSqlBuilder(SqlFactory sqlFactory) {
        super(sqlFactory);
    }

    @Override
    public String buildSelect(Table table, List<Value> values) {

        return this.sqlFactory.getSelectSql(table, values);
    }

    @Override
    public String buildInsert(Table table, List<Value> values) {

        return this.sqlFactory.getInsertSql(table, values);
    }

    @Override
    public String buildUpdate(Table table, List<Value> values) {

        return this.sqlFactory.getUpdateSql(table, values);
    }

    @Override
    public String buildDelete(Table table, List<Value> values) {

        return this.sqlFactory.getDeleteSql(table, values);
    }
}
