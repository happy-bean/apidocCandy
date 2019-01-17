package org.happbean.candy.apidoc.internal.db;

import java.sql.*;

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
    public long executeInsert(String sql) throws SQLException {

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        Object id = null;
        if (generatedKeys.next()) {
            id = generatedKeys.getObject(1);
        }
        preparedStatement.close();

        return (long) id;
    }

    @Override
    public long executeSelect(String sql) throws SQLException {
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        long columnCount = resultSet.getMetaData().getColumnCount();
        resultSet.close();
        preparedStatement.close();
        return columnCount;
    }

    @Override
    public long executeUpdate(String sql) throws SQLException {

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        long num = preparedStatement.executeUpdate();
        preparedStatement.close();

        return num;
    }

    @Override
    public long executeDelete(String sql) throws SQLException {

        return executeUpdate(sql);
    }
}