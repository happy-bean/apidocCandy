package org.happbean.candy.apidoc.internal.sql;

import org.happbean.candy.apidoc.internal.factory.SqlFactory;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public abstract class SqlBuilder<T, E> {

    protected SqlFactory sqlFactory;

    public SqlBuilder(SqlFactory sqlFactory) {
        this.sqlFactory = sqlFactory;
    }

    public abstract String buildSelect(T t, E e);

    public abstract String buildInsert(T t, E e);

    public abstract String buildUpdate(T t, E e);

    public abstract String buildDelete(T t, E e);
}
