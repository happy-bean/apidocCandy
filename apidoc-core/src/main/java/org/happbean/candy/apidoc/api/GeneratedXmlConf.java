package org.happbean.candy.apidoc.api;

import org.happbean.candy.apidoc.config.xml.XmlConfFormatter;
import org.happbean.candy.apidoc.config.xml.xmlpo.CandyConfiguration;
import org.happbean.candy.apidoc.internal.system.JdbcSystem;

import java.util.ResourceBundle;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public class GeneratedXmlConf extends GeneratedConf {

    private String fileName;

    private String xmlPath;

    public GeneratedXmlConf(String fileName, String projectPath) {

        super(projectPath);
        this.fileName = fileName;
        this.xmlPath = projectPath + "." + this.fileName;
    }

    @Override
    void generated() {

        CandyConfiguration configuration = XmlConfFormatter.parse(this.xmlPath);
        ResourceBundle bundle = ResourceBundle.getBundle(configuration.getProperties().getResource());

        JdbcSystem.init(configuration.getJdbcConnection(), bundle);
    }
}
