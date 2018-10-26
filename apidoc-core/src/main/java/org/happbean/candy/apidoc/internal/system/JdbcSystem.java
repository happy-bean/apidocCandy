package org.happbean.candy.apidoc.internal.system;

import org.happbean.candy.apidoc.config.xml.elements.CandyConfiguration;
import org.happbean.candy.apidoc.config.xml.elements.JdbcConnection;
import org.happbean.candy.apidoc.util.StringUtil;

import java.util.ResourceBundle;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public class JdbcSystem {

    public static final JdbcConnection JDBC_CONNECTION = new JdbcConnection();

    public static void init(CandyConfiguration configuration) {

        converteVariables(configuration);
    }

    private static boolean useProperties(String value) {

        return StringUtil.isNotBlank(value) && StringUtil.isWrap(value, "${", "}");
    }

    private static void converteVariables(CandyConfiguration configuration) {

        ResourceBundle bundle = ResourceBundle.getBundle(configuration.getProperties().getResource());
        JdbcConnection connection = configuration.getJdbcConnection();

        if (useProperties(connection.getDriverClass())) {
            String key = StringUtil.unWrap(connection.getDriverClass(), "${", "}");
            JDBC_CONNECTION.setDriverClass(bundle.getString(key));
        } else {
            JDBC_CONNECTION.setDriverClass(connection.getDriverClass());
        }

        if (useProperties(connection.getClassPath())) {
            String key = StringUtil.unWrap(connection.getClassPath(), "${", "}");
            JDBC_CONNECTION.setClassPath(bundle.getString(key));
        } else {
            JDBC_CONNECTION.setConnectionURL(connection.getClassPath());
        }

        if (useProperties(connection.getConnectionURL())) {
            String key = StringUtil.unWrap(connection.getConnectionURL(), "${", "}");
            JDBC_CONNECTION.setConnectionURL(bundle.getString(key));
        } else {
            JDBC_CONNECTION.setConnectionURL(connection.getConnectionURL());
        }

        if (useProperties(connection.getUserId())) {
            String key = StringUtil.unWrap(connection.getUserId(), "${", "}");
            JDBC_CONNECTION.setUserId(bundle.getString(key));
        } else {
            JDBC_CONNECTION.setUserId(connection.getUserId());
        }

        if (useProperties(connection.getPassword())) {
            String key = StringUtil.unWrap(connection.getPassword(), "${", "}");
            JDBC_CONNECTION.setPassword(bundle.getString(key));
        } else {
            JDBC_CONNECTION.setPassword(connection.getPassword());
        }
    }
}
