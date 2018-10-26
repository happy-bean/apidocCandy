package org.happbean.candy.apidoc.config.xml.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class Properties {

    private String resource;

    @XmlAttribute(name = "resource")
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
