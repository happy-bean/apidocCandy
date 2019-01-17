package org.happbean.candy.apidoc.internal.system;

import org.happbean.candy.apidoc.config.xml.elements.CandyConfiguration;
import org.happbean.candy.apidoc.config.xml.elements.JavaSource;
import org.happbean.candy.apidoc.config.xml.elements.JavaTypeResolver;
import org.happbean.candy.apidoc.internal.load.JarLoader;

import static org.happbean.candy.apidoc.internal.system.JdbcSystem.JDBC_CONNECTION;

/**
 * @author wgt
 * @date 2018-10-25
 * @description
 **/
public class JavaSystem {

    public static final JavaTypeResolver JAVA_TYPE_RESOLVER = new JavaTypeResolver();

    public static final JavaSource JAVA_SOURCE = new JavaSource();

    public static void init(CandyConfiguration configuration) {

        initJavaSource(configuration.getJavaSource());
        initJavaTypeResolver(configuration.getJavaTypeResolver());

        try {
            JarLoader.loadJar(JDBC_CONNECTION.getClassPath());
        }catch (Exception e){
            //TODO
        }
    }

    public static void initJavaSource(JavaSource source) {

        JAVA_SOURCE.setPackage(source.getPackage());
    }
    public static void initJavaTypeResolver(JavaTypeResolver resolver) {

        JAVA_TYPE_RESOLVER.setProperties(resolver.getProperties());
    }
}
