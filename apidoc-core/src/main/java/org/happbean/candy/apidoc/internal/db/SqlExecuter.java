package org.happbean.candy.apidoc.internal.db;


import java.sql.SQLException;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
@FunctionalInterface
public interface SqlExecuter {

    Object excute() throws SQLException;
}
