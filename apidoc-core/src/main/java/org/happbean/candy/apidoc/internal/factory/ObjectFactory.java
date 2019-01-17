package org.happbean.candy.apidoc.internal.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public class ObjectFactory {

    private static List<ClassLoader> externalClassLoaders;

    static {
        externalClassLoaders = new ArrayList<>();
    }

    public static Class<?> externalClassForName(String className) throws ClassNotFoundException {

        Class<?> clazz;

        for (ClassLoader classLoader : externalClassLoaders) {
            try {
                clazz = Class.forName(className, true, classLoader);
                return clazz;
            } catch (Throwable e) {
                // ignore
            }
        }

        return internalClassForName(className);
    }

    public static Class<?> internalClassForName(String className) throws ClassNotFoundException {
        Class<?> clazz = null;

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            clazz = Class.forName(className, true, classLoader);
        } catch (Exception e) {
            // ignore
        }

        if (clazz == null) {
            clazz = Class.forName(className, true, ObjectFactory.class.getClassLoader());
        }

        return clazz;
    }
}
