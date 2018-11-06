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

    private static Parser getApiParser(Api api) {

        Parser parser = () -> {
            return api;
        };

        return parser;
    }

    private static Parser getActionParser(Action action) {

        Parser parser = () -> {
            return action;
        };

        return parser;
    }

    private static Parser getParamParser(Param param) {

        Parser parser = () -> {
            return param;
        };

        return parser;
    }

    private static Parser getResultParser(Result result) {

        Parser parser = () -> {
            return result;
        };

        return parser;
    }
}
