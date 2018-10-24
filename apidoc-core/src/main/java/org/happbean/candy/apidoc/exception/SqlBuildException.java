package org.happbean.candy.apidoc.exception;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public class SqlBuildException extends RuntimeException {

    public SqlBuildException() {
        super();
    }

    public SqlBuildException(String message) {
        super(message);
    }

    public SqlBuildException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlBuildException(Throwable cause) {
        super(cause);
    }
}
