package org.happbean.candy.apidoc.factory.annotation.request;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author wgt
 * @date 2018-09-14
 * @description
 **/
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Documented
public @interface Param {

    String name() default "";

    String value() default "";

    boolean required() default true;

    String desc() default "";
}