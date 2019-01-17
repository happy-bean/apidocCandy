package org.happbean.candy.apidoc.config.xml.elements;

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

    private String property;

    private List<Column> columns;

    @XmlAttribute(name = "tableName")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @XmlAttribute(name = "property")
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @XmlElement(name = "column")
    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
