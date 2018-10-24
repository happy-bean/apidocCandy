package org.happbean.candy.apidoc.internal.sql;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public abstract class SqlBuilder<T, E> {

    public SqlFactory sqlFactory;

    public SqlBuilder(SqlFactory sqlFactory) {
        this.sqlFactory = sqlFactory;
    }

    abstract String buildSelect(T t, E e);

    abstract String buildInsert(T t, E e);

    abstract String buildUpdate(T t, E e);

    abstract String buildDelete(T t, E e);
}
