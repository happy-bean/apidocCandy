package org.happbean.candy.apidoc.factory.annotation.response;

/**
 * @author wgt
 * @date 2018-09-14
 * @description
 **/
public @interface Result {

    String name() default "";

    String value() default "";

    String desc() default "";
}
