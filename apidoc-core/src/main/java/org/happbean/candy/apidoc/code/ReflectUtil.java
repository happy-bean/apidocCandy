package org.happbean.candy.apidoc.code;


/**
 * @author wgt
 * @date 2018-09-17
 * @description
 **/
public class ReflectUtil {

    public static Class<?> getClassForName(final String className) {

        Class<?> clazz = null;

        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    public static Object getNewInstance(Class clazz) {

        if (clazz == null) {
            return null;
        }

        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
