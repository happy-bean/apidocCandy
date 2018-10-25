package org.happbean.candy.apidoc.config.xml.xmlpo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
@XmlRootElement(name = "candyConfiguration")
public class CandyConfiguration {

    private Properties properties;

    private JdbcConnection jdbcConnection;

    private JavaSource javaSource;

    private Tables tables;

    private JavaTypeResolver javaTypeResolver;

    @XmlElement(name = "properties")
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @XmlElement(name = "jdbcConnection")
    public JdbcConnection getJdbcConnection() {
        return jdbcConnection;
    }

    public void setJdbcConnection(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    @XmlElement(name = "javaSource")
    public JavaSource getJavaSource() {
        return javaSource;
    }

    public void setJavaSource(JavaSource javaSource) {
        this.javaSource = javaSource;
    }

    @XmlElement(name = "tables")
    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public JavaTypeResolver getJavaTypeResolver() {
        return javaTypeResolver;
    }

    @XmlElement(name = "javaTypeResolver")
    public void setJavaTypeResolver(JavaTypeResolver javaTypeResolver) {
        this.javaTypeResolver = javaTypeResolver;
    }
}
