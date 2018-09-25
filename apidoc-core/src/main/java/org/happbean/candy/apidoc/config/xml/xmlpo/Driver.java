package org.happbean.candy.apidoc.config.xml.xmlpo;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class Driver {

    private String classPath;

    private String driverClass;

    @XmlElement(name = "classPath")
    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    @XmlElement(name = "driverClass")
    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }
}
