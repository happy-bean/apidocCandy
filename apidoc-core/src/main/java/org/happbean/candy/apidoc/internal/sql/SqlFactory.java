package org.happbean.candy.apidoc.internal.sql;

import org.happbean.candy.apidoc.exception.SqlBuildException;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public interface SqlFactory<T, E> {

    String getInsertSql(T t, E e);

    String getSelectSql(T t, E e);

    String getDeleteSql(T t, E e);

    String getUpdateSql(T t, E e);
}
