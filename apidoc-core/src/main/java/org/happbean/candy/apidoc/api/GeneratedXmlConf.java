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

    private String fileName;

    private String xmlPath;

    public GeneratedXmlConf(String fileName, String projectPath) {

        super(projectPath);

        this.fileName = fileName;
        this.xmlPath = projectPath + "/" + this.fileName;
    }

    @Override
    public void generated() {

        CandyConfiguration configuration = XmlConfFormatter.parse(this.xmlPath);

        JdbcSystem.init(configuration);

        DbSystem.init(configuration);

        JavaSystem.init(configuration);
    }
}
