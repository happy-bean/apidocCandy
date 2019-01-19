package org.happbean.candy.apidoc.api;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public abstract class GeneratedConf {

    protected String xmlConfigPath;

    public GeneratedConf(String xmlConfigPath) {
        this.xmlConfigPath = xmlConfigPath;
    }

    abstract  void generated();
}
