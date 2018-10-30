package org.happbean.candy.apidoc.util;

/**
 * @author wgt
 * @date 2018-10-29
 * @description
 **/
public class ArrayUtil {

    public static boolean isEmpty(Object[] objects) {

        return objects == null || objects.length == 0;
    }

    public static boolean isNotEmpty(Object[] objects) {

        return objects != null || objects.length > 0;
    }
}
