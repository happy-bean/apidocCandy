package org.happbean.candy.apidoc.internal.factory;

import org.happbean.candy.apidoc.internal.system.JdbcSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wgt
 * @date 2018-11-07
 * @description
 **/
public class ConnectionFactory {

    static {
        try {
            ObjectFactory.internalClassForName(JdbcSystem.JDBC_CONNECTION.getDriverClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection = null;

    static {
        try {
            connection = (Connection) DriverManager.getConnection(JdbcSystem.JDBC_CONNECTION.getConnectionURL(), JdbcSystem.JDBC_CONNECTION.getUserId(), JdbcSystem.JDBC_CONNECTION.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        return connection;
    }

    public static void closeConnection(){

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
