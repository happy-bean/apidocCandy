package org.happbean.candy.apidoc.config.xml.xmlpo;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class JavaSource {

    private ApiSource apiSource;

    @XmlElement(name = "apiSource")
    public ApiSource getApiSource() {
        return apiSource;
    }

    public void setApiSource(ApiSource apiSource) {
        this.apiSource = apiSource;
    }
}
