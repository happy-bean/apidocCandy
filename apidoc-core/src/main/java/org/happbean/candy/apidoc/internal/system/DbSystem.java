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

    public static final Map<String, Table> TABLES = new HashMap<>();

    public static void init(CandyConfiguration configuration) {

        initTables(configuration.getTables());
    }


    public static void initTables(Tables tables) {
        if (tables == null) {
            //throw
        }

        if (CollectionUtil.isEmpty(tables.getTables())) {
            //throw
        }

        tables.getTables().stream().forEach(table -> {

            TABLES.putIfAbsent(table.getProperty(), table);
        });
    }

}
