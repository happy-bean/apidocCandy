package org.happbean.candy.apidoc.factory.annotation.request;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Header {

    String name() default "";

    String value() default "";

    boolean required() default true;

    String desc() default "";
}
