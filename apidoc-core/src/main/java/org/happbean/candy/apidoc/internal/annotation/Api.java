package org.happbean.candy.apidoc.internal.annotation;

import java.lang.annotation.*;

/**
 * @author wgt
 * @date 2018-09-14
 * @description
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Api {

    String value() default "";
}
