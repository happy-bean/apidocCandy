package org.happbean.candy.apidoc.internal.system;

import org.happbean.candy.apidoc.config.xml.elements.CandyConfiguration;
import org.happbean.candy.apidoc.config.xml.elements.JavaTypeResolver;

/**
 * @author wgt
 * @date 2018-10-25
 * @description
 **/
public class JavaTypeSystem {

    public static final JavaTypeResolver JAVA_TYPE_RESOLVER = new JavaTypeResolver();

    public static void init(CandyConfiguration configuration) {

        initJavaTypeResolver(configuration.getJavaTypeResolver());
    }

    public static void initJavaTypeResolver(JavaTypeResolver resolver) {

        JAVA_TYPE_RESOLVER.setProperties(resolver.getProperties());
    }
}
