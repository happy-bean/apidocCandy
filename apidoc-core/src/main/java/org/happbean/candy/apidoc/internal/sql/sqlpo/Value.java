package org.happbean.candy.apidoc.internal.sql.sqlpo;

import lombok.Data;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
@Data
public class Value {

    private String columnName;

    private String columnValue;

    public Value(String columnName, String columnValue) {
        this.columnName = columnName;
        this.columnValue = columnValue;
    }
}
