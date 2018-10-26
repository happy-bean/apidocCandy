package org.happbean.candy.apidoc.config.xml.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author wgt
 * @date 2018-10-25
 * @description
 **/
public class Property {

    private String javaType;

    private String apiType;

    public String getJavaType() {
        return javaType;
    }

    @XmlAttribute(name = "javaType")
    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getApiType() {
        return apiType;
    }

    @XmlAttribute(name = "apiType")
    public void setApiType(String apiType) {
        this.apiType = apiType;
    }
}
