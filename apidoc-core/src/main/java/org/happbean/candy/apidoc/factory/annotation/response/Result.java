package org.happbean.candy.apidoc.factory.annotation.response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wgt
 * @date 2018-09-14
 * @description
 **/
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Result {

    String name() default "";

    String value() default "";

    String desc() default "";
}
