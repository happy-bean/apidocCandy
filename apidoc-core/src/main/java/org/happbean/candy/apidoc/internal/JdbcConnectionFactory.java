package org.happbean.candy.apidoc.internal;


import org.happbean.candy.apidoc.config.xml.xmlpo.JdbcConnection;
import org.happbean.candy.apidoc.internal.factory.ObjectFactory;
import org.happbean.candy.apidoc.util.StringUtil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public class JdbcConnectionFactory {

    private String userId;

    private String password;

    private String connectionURL;

    private String driverClass;

    public JdbcConnectionFactory(JdbcConnection config) {

        this.userId = config.getUserId();
        this.password = config.getPassword();
        this.connectionURL = config.getConnectionURL();
        this.driverClass = config.getDriverClass();
    }

    public Connection getConnection() throws SQLException {

        Properties props = new Properties();

        if (StringUtil.isNotEmpty(this.userId)) {
            props.setProperty("user", this.userId);
        }

        if (StringUtil.isNotEmpty(this.password)) {
            props.setProperty("password", this.password);
        }

        Driver driver = this.getDriver();
        Connection conn = driver.connect(this.connectionURL, props);

        if (conn == null) {
            //throw new SQLException(Messages.getString("RuntimeError.7"));
            throw new SQLException("");
        } else {
            return conn;
        }
    }

    private Driver getDriver() {

        try {

            Class<?> clazz = ObjectFactory.externalClassForName(this.driverClass);
            Driver driver = (Driver) clazz.newInstance();
            return driver;
        } catch (Exception e) {
            throw new RuntimeException("RuntimeError.8", e);
        }
    }
}
