package org.happbean.candy.apidoc.internal.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wgt
 * @date 2018-11-06
 * @description
 **/
public class DefaultSqlExecuter extends Executer {

    public DefaultSqlExecuter(Connection connection) {
        super(connection);
    }

    @Override
    public int executeInsert(String sql) throws SQLException {

        return executeUpdate(sql);
    }

    @Override
    public ResultSet executeSelect(String sql) throws SQLException {

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();

        return resultSet;
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        int num = preparedStatement.executeUpdate();
        preparedStatement.close();

        return num;
    }

    @Override
    public int executeDelete(String sql) throws SQLException {

        return executeUpdate(sql);
    }
}