package org.happbean.candy.apidoc.demo;

import org.happbean.candy.apidoc.factory.annotation.Api;
import org.happbean.candy.apidoc.factory.annotation.request.Action;
import org.happbean.candy.apidoc.factory.annotation.request.Param;
import org.happbean.candy.apidoc.factory.enums.HttpMethod;

import javax.annotation.Resource;

/**
 * @author wgt
 * @date 2018-09-15
 * @description
 **/
@Api(value = "UserController")
public class UserController {

    @Action(path = "/user-info", method = {HttpMethod.GET}, desc = "get user info by user id")
    public User getUserInfo(@Param(name = "user_id", required = true, desc = "user id") int userId) {

        return null;
    }
}
