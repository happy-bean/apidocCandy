package org.happbean.candy.apidoc.internal.system;

import org.happbean.candy.apidoc.internal.db.dos.*;

import java.util.Arrays;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public class ApiSqlSystem {

    public static Action initAction(org.happbean.candy.apidoc.internal.annotation.request.Action action) {
        Action ACTION = new Action();

        ACTION.setName(action.name());
        if (action.method() != null) {
            StringBuilder builder = new StringBuilder();
            Arrays.stream(action.method()).forEach(httpMethod -> {
                builder.append(httpMethod.name()).append("|");
            });
            builder.deleteCharAt(builder.length() - 1);
            ACTION.setMethod(builder.toString());
        }
        ACTION.setPath(action.path());
        ACTION.setDesc(action.desc());

        return ACTION;
    }

    public static Header initHeader(org.happbean.candy.apidoc.internal.annotation.request.Header header) {
        Header HEADER = new Header();

        HEADER.setName(header.name());
        HEADER.setRequired(String.valueOf(header.required()));
        HEADER.setDesc(header.desc());

        return HEADER;
    }

    public static Param initParam(org.happbean.candy.apidoc.internal.annotation.request.Param param) {
        Param PARAM = new Param();

        PARAM.setName(param.name());
        PARAM.setDesc(param.desc());
        PARAM.setRequired(String.valueOf(param.required()));

        return PARAM;
    }

    public static Result initResult(org.happbean.candy.apidoc.internal.annotation.response.Result result) {
        Result RESULT = new Result();
        if(result!=null) {
            RESULT.setName(result.name());
            RESULT.setValue(result.value());
            RESULT.setDesc(result.desc());
        }
        return RESULT;
    }
}
