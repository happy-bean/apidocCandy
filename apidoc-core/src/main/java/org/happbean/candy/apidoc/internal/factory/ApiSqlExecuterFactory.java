package org.happbean.candy.apidoc.internal.factory;

import org.happbean.candy.apidoc.internal.db.DefaultSqlExecuter;
import org.happbean.candy.apidoc.internal.db.Executer;
import org.happbean.candy.apidoc.internal.db.SqlExecuter;
import org.happbean.candy.apidoc.internal.db.dos.*;
import org.happbean.candy.apidoc.internal.sql.ApiSqlBuilder;


/**
 * @author wgt
 * @date 2018-11-06
 * @description
 **/
public class ApiSqlExecuterFactory {

    public static SqlExecuter getApiSqlExecuter(ApiDbObject object) {

        SqlExecuter executer = null;

        if (object instanceof Action) {

            executer = getActionSqlExecuter((Action) object);
        } else if (object instanceof Param) {

            executer = getParamSqlExecuter((Param) object);
        } else if (object instanceof Header) {

            executer = getHeaderSqlExecuter((Header) object);
        } else if (object instanceof Result) {

            executer = getResultSqlExecuter((Result) object);
        }else {

        }

        return executer;
    }

    private static SqlExecuter getSqlExecuter(ApiDbObject object) {

        SqlExecuter sqlExecuter = () -> {

            Executer executer = new DefaultSqlExecuter(ConnectionFactory.getConnection());

            ApiSqlBuilder sqlBuilder = new ApiSqlBuilder(object);

            long columnCount = executer.executeSelect(sqlBuilder.buildSelectSql());

            if (columnCount != 0) {

                long i = executer.executeDelete(sqlBuilder.buildDeleteSql());
            }

            long i = executer.executeInsert(sqlBuilder.buildInsertSql());
            executer.connection.close();
            return i;
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
