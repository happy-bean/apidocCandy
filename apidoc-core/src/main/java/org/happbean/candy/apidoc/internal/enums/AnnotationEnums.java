package org.happbean.candy.apidoc.internal.enums;

import org.happbean.candy.apidoc.internal.annotation.Api;
import org.happbean.candy.apidoc.internal.annotation.request.Action;
import org.happbean.candy.apidoc.internal.annotation.request.Param;
import org.happbean.candy.apidoc.internal.annotation.response.Result;

/**
 * @author wgt
 * @date 2018-09-18
 * @description
 **/
public enum AnnotationEnums {

    API(Api.class),

    ACTION(Action.class),

    PARAM(Param.class),

    RESULT(Result.class);

    private Class clazz;

    AnnotationEnums(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return this.clazz;
    }
}
