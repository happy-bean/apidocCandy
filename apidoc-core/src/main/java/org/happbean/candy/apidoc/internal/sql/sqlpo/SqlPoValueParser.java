package org.happbean.candy.apidoc.internal.sql.sqlpo;

import java.util.List;

/**
 * @author wgt
 * @date 2018-11-06
 * @description
 **/
@FunctionalInterface
public interface SqlPoValueParser {

    List<Value> parseValue();

}
