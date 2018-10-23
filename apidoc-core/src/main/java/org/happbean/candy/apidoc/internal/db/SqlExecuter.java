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
public class SqlExecuter extends Executer {

    public SqlExecuter(Connection connection) {
        super(connection);
    }

    public int executeInsert(String sql) throws SQLException {

        return executeUpdate(sql);
    }

    public ResultSet executeSelect(String sql) throws SQLException {

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public int executeUpdate(String sql) throws SQLException {

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        int num = preparedStatement.executeUpdate();
        return num;
    }

    public int executeDelete(String sql) throws SQLException {

        return executeUpdate(sql);
    }
}
