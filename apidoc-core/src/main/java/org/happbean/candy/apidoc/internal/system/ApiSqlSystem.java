package org.happbean.candy.apidoc.internal.system;

import org.happbean.candy.apidoc.config.confpo.Action;
import org.happbean.candy.apidoc.config.confpo.Header;
import org.happbean.candy.apidoc.config.confpo.Param;
import org.happbean.candy.apidoc.config.confpo.Result;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public class ApiSqlSystem {

    public static final Action ACTION = new Action();

    public static final Header HEADER = new Header();

    public static final Param PARAM = new Param();

    public static final Result RESULT = new Result();

    public static void init(Action action, Header header, Param param, Result result) {

    }

    private static void initAction(Action action) {

        ACTION.setId(action.getId());
        ACTION.setName(action.getName());
        ACTION.setMethod(action.getMethod());
        ACTION.setPath(action.getPath());
        ACTION.setDesc(action.getDesc());
    }

    private static void initHeader(Header header) {

        HEADER.setId(header.getId());
        HEADER.setActionId(header.getActionId());
        HEADER.setName(header.getName());
        HEADER.setRequired(header.getRequired());
        HEADER.setDesc(header.getDesc());
    }

    private static void initParam(Param param) {

        PARAM.setId(param.getId());
        PARAM.setActionId(param.getActionId());
        PARAM.setName(param.getName());
        PARAM.setType(param.getType());
        PARAM.setDesc(param.getDesc());
        PARAM.setRequired(param.getRequired());
        PARAM.setLastId(param.getLastId());
    }

    private static void initResult(Result result) {

        RESULT.setId(result.getId());
        RESULT.setActionId(result.getActionId());
        RESULT.setName(result.getName());
        RESULT.setType(result.getType());
        RESULT.setValue(result.getValue());
        RESULT.setDesc(result.getDesc());
        RESULT.setLastId(result.getLastId());
    }
}
