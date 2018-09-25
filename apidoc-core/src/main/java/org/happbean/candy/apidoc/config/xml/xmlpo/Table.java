package org.happbean.candy.apidoc.config.xml.xmlpo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class Table {

    private String tableName;

    private List<Column> columns;

    @XmlAttribute(name = "tableName")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @XmlElement(name = "column")
    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
