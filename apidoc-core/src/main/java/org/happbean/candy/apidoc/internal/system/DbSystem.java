package org.happbean.candy.apidoc.internal.system;

import org.happbean.candy.apidoc.config.xml.elements.*;

/**
 * @author wgt
 * @date 2018-10-25
 * @description
 **/
public class DbSystem {

    public static final JavaSource JAVA_SOURCE = new JavaSource();

    public static final Tables TABLES = new Tables();

    public static void init(CandyConfiguration configuration) {

        initJavaSource(configuration.getJavaSource());
        initTables(configuration.getTables());
    }

    public static void initJavaSource(JavaSource source) {

        JAVA_SOURCE.setPackage(source.getPackage());
    }

    public static void initTables(Tables tables) {

        TABLES.setTables(tables.getTables());
    }

}
