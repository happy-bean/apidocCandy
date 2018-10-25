package org.happbean.candy.apidoc.config.xml.xmlpo;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class ApiSource {

    private String packaga;

    @XmlAttribute(name = "package")
    public String getPackage() {
        return packaga;
    }

    public void setPackage(String packaga) {
        this.packaga = packaga;
    }
}
