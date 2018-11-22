package org.happbean.candy.apidoc.internal.factory;

import org.happbean.candy.apidoc.internal.annotation.request.Action;
import org.happbean.candy.apidoc.internal.annotation.request.Header;
import org.happbean.candy.apidoc.internal.annotation.request.Param;
import org.happbean.candy.apidoc.internal.annotation.response.Result;
import org.happbean.candy.apidoc.internal.db.DefaultSqlExecuter;
import org.happbean.candy.apidoc.internal.db.Executer;
import org.happbean.candy.apidoc.internal.db.SqlExecuter;
import org.happbean.candy.apidoc.internal.sql.ApiSqlBuilder;

import java.lang.annotation.Annotation;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wgt
 * @date 2018-11-06
 * @description
 **/
public class ApiSqlExecuterFactory {

    public static SqlExecuter getApiSqlExecuter(Object annotation) {

        SqlExecuter executer = null;

        if (annotation instanceof Action) {

            executer = getActionSqlExecuter((Action) annotation);
        } else if (annotation instanceof Param) {

            executer = getParamSqlExecuter((Param) annotation);
        } else if (annotation instanceof Header) {

            executer = getHeaderSqlExecuter((Header) annotation);
        } else if (annotation instanceof Result) {

            executer = getResultSqlExecuter((Result) annotation);
        }

        return executer;
    }

    private static SqlExecuter getSqlExecuter(Annotation annotation) {

        SqlExecuter sqlExecuter = () -> {

            Executer executer = new DefaultSqlExecuter(ConnectionFactory.getConnection());

            ApiSqlBuilder sqlBuilder = new ApiSqlBuilder(annotation);

            ResultSet resultSet = executer.executeSelect(sqlBuilder.buildSelectSql());

            int columnCount = resultSet.getMetaData().getColumnCount();

            resultSet.close();

            if (columnCount != 0) {

                int i = executer.executeDelete(sqlBuilder.buildDeleteSql());
            }

            try {
                executer.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return executer.executeInsert(sqlBuilder.buildInsertSql());
        };

        return sqlExecuter;
    }

    private static SqlExecuter getActionSqlExecuter(Action action) {

        return getSqlExecuter(action);
    }

    private static SqlExecuter getHeaderSqlExecuter(Header header) {

        return getSqlExecuter(header);
    }

    private static SqlExecuter getParamSqlExecuter(Param param) {

        return getSqlExecuter(param);
    }

    private static SqlExecuter getResultSqlExecuter(Result result) {

        return getSqlExecuter(result);
    }
}
