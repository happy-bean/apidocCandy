package org.happbean.candy.apidoc.internal.system;

import org.happbean.candy.apidoc.config.xml.elements.*;
import org.happbean.candy.apidoc.util.CollectionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgt
 * @date 2018-10-25
 * @description
 **/
public class DbSystem {

    public static final JavaSource JAVA_SOURCE = new JavaSource();

    public static final Map<String, Table> TABLES = new HashMap<>();

    public static void init(CandyConfiguration configuration) {

        initJavaSource(configuration.getJavaSource());
        initTables(configuration.getTables());
    }

    public static void initJavaSource(JavaSource source) {

        JAVA_SOURCE.setPackage(source.getPackage());
    }

    public static void initTables(Tables tables) {
        if (tables == null) {
            //throw
        }

        if (CollectionUtil.isEmpty(tables.getTables())) {
            //throw
        }

        tables.getTables().stream().forEach(table -> {

            TABLES.putIfAbsent(table.getTableName(), table);
        });
    }

}
