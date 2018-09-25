package org.happbean.candy.apidoc.config.xml.xmlpo;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class JdbcConnection {

    private Driver driver;

    private String connectionURL;

    private String userId;

    private String password;

    @XmlElement(name = "driver")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @XmlElement(name = "connectionURL")
    public String getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    @XmlElement(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
