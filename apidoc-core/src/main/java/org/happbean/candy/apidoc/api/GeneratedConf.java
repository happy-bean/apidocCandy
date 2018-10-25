package org.happbean.candy.apidoc.api;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public abstract class GeneratedConf {

    protected String projectPath;

    public GeneratedConf(String projectPath) {
        this.projectPath = projectPath;
    }

    abstract void generated();
}
