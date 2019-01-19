package org.happbean.candy.apidoc.api;

import org.happbean.candy.apidoc.config.xml.XmlConfFormatter;
import org.happbean.candy.apidoc.config.xml.elements.CandyConfiguration;
import org.happbean.candy.apidoc.internal.system.DbSystem;
import org.happbean.candy.apidoc.internal.system.JavaSystem;
import org.happbean.candy.apidoc.internal.system.JdbcSystem;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public class GeneratedXmlConf extends GeneratedConf {

    public GeneratedXmlConf(String xmlConfigPath) {

        super(xmlConfigPath);
    }

    @Override
    public void generated() {

        CandyConfiguration configuration = XmlConfFormatter.parse(this.xmlConfigPath);

        JdbcSystem.init(configuration);

        DbSystem.init(configuration);

        JavaSystem.init(configuration);
    }
}
