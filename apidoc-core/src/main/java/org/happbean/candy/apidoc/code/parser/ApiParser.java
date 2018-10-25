package org.happbean.candy.apidoc.code.parser;

import org.happbean.candy.apidoc.factory.annotation.Api;
import org.happbean.candy.apidoc.factory.annotation.request.Action;
import org.happbean.candy.apidoc.factory.annotation.request.Param;
import org.happbean.candy.apidoc.factory.annotation.response.Result;

/**
 * @author wgt
 * @date 2018-09-21
 * @description
 **/
public class ApiParser {

    public static Parser getParser(Object annotation) {

        Parser parser = null;

        if (annotation instanceof Api) {
            parser = getApiParser((Api) annotation);
        } else if (annotation instanceof Action) {
            parser = getActionParser((Action) annotation);
        } else if (annotation instanceof Param) {
            parser = getParamParser((Param) annotation);
        } else if (annotation instanceof Result) {
            parser = getResultParser((Result) annotation);
        }

        return parser;
    }

    public static Parser getApiParser(Api api) {

        Parser parser = () -> {
            System.out.println(api.value());
        };

        return parser;
    }

    public static Parser getActionParser(Action action) {

        Parser parser
                = () -> System.out.println(action.name() + " " + action.path() + "...");

        return parser;
    }

    public static Parser getParamParser(Param param) {

        Parser parser = () -> System.out.println(param.name() + " " + param.desc() + "...");

        return parser;
    }

    public static Parser getResultParser(Result result) {

        Parser parser = () -> System.out.println(result.name() + " " + result.desc());

        return parser;
    }
}
