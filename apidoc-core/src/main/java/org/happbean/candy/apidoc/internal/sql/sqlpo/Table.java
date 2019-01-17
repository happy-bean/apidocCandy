package org.happbean.candy.apidoc.internal.sql.sqlpo;

import org.happbean.candy.apidoc.config.xml.elements.Column;

import java.util.List;

/**
 * @author wgt
 * @date 2018-11-06
 * @description
 **/
public class Table {

    private String tableName;

    private List<Column> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
