package org.happbean.candy.apidoc.internal.sql.sqlpo;

import lombok.Data;
import org.happbean.candy.apidoc.config.xml.elements.Column;

import java.util.List;

/**
 * @author wgt
 * @date 2018-11-06
 * @description
 **/
@Data
public class Table {

    private String tableName;

    private List<Column> columns;
}
