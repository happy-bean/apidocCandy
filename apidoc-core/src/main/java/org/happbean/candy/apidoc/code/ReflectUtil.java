package org.happbean.candy.apidoc.code;


/**
 * @author wgt
 * @date 2018-09-17
 * @description
 **/
public class ReflectUtil {

    public static Class<?> getClassForName(String className) {

        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
