package org.happbean.candy.apidoc.config.xml.elements;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author wgt
 * @date 2018-10-25
 * @description
 **/
public class JavaTypeResolver {

    private List<Property> properties;

    @XmlElement(name = "property")
    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
