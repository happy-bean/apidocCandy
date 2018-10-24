package org.happbean.candy.apidoc.util;

import java.util.Collection;

/**
 * @author wgt
 * @date 2018-10-23
 * @description
 **/
public class CollectionUtil {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return collection != null && collection.size() > 0;
    }
}
