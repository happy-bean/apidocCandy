package org.happbean.candy.apidoc.demo;

import org.happbean.candy.apidoc.internal.annotation.Api;
import org.happbean.candy.apidoc.internal.annotation.request.Action;
import org.happbean.candy.apidoc.internal.annotation.request.Header;
import org.happbean.candy.apidoc.internal.annotation.request.Param;
import org.happbean.candy.apidoc.internal.enums.HttpMethod;

/**
 * @author wgt
 * @date 2018-09-15
 * @description
 **/
@Api(value = "userController")
public class UserController {

    @Action(name = "select user info", path = "/select", method = {HttpMethod.GET}, desc = "select user info by user id", headers = {@Header(name = "app_id", desc = "api_candy_doc_app_id")})
    public User select(@Param(name = "user_id", required = true, desc = "user id") int userId) {
        //...
        return null;
    }

    @Action(name = "insert user info", path = "/insert", method = {HttpMethod.POST}, desc = "insert user info", headers = {@Header(name = "session_id", desc = "a596c48a-2805-44f5-b336-aec208f2ff18")})
    public int insert(@Param(name = "user", required = true, desc = "user info") User user) {
        //...
        return 0;
    }

    @Action(name = "update user info", path = "/update", method = {HttpMethod.PUT}, desc = "update user info", headers = {@Header(name = "cookie", desc = "a596c48a-2805-44f5-b336-aec208f2ff18")})
    public int update(@Param(name = "num", required = false, desc = "user num") String num,
                      @Param(name = "pass", required = false, desc = "user pass") String pass) {
        //...
        return 0;
    }
}
