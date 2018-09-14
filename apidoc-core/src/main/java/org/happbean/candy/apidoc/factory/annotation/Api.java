package org.happbean.candy.apidoc.factory.annotation;

import org.happbean.candy.apidoc.factory.enums.HttpMethod;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author wgt
 * @date 2018-09-14
 * @description
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Api {

    String name() default "";

    String[] path() default {};

    HttpMethod[] method() default {};

    String[] params() default {};

    String[] headers() default {};

    String desc() default "";
}
