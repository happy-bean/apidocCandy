package org.happbean.candy.apidoc.internal.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public abstract int executeInsert(String sql) throws SQLException;

    public abstract ResultSet executeSelect(String sql) throws SQLException;

    public abstract int executeUpdate(String sql) throws SQLException;

    public abstract int executeDelete(String sql) throws SQLException;

}
