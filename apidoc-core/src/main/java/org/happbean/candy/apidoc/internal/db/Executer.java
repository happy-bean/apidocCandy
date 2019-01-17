package org.happbean.candy.apidoc.internal.db;

import java.sql.Connection;
import java.sql.SQLException;

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

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    public abstract long executeInsert(String sql) throws SQLException;

    public abstract long executeSelect(String sql) throws SQLException;

    public abstract long executeUpdate(String sql) throws SQLException;

    public abstract long executeDelete(String sql) throws SQLException;

}
