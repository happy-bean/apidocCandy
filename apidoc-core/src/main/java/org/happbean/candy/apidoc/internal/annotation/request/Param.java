package org.happbean.candy.apidoc.internal.annotation.request;

import java.lang.annotation.*;

/**
 * @author wgt
 * @date 2018-09-14
 * @description
 **/
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

    String name() default "";

    boolean required() default true;

    String desc() default "";
}