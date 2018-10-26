package org.happbean.candy.apidoc.factory.annotation.request;

import org.happbean.candy.apidoc.factory.enums.HttpMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wgt
 * @date 2018-09-17
 * @description
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {

    String name() default "";

    String path() default "";

    HttpMethod[] method() default {};

    Header[] headers() default {};

    String desc() default "";
}
