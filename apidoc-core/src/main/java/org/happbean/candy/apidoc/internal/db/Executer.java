package org.happbean.candy.apidoc.internal.db;

import java.sql.Connection;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public abstract class Executer {

    public Connection connection = null;

    public Executer(Connection connection) {
        this.connection = connection;
    }

}
