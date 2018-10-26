package org.happbean.candy.apidoc.config.xml.elements;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class Tables {

    private List<Table> tables;

    @XmlElement(name = "table")
    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
