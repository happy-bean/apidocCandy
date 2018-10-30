package org.happbean.candy.apidoc.demo;

import lombok.Data;
import org.happbean.candy.apidoc.factory.annotation.request.Param;
import org.happbean.candy.apidoc.factory.annotation.response.Result;

/**
 * @author wgt
 * @date 2018-09-15
 * @description
 **/
@Data
@Result
public class User {

    @Param(name = "num", required = true, desc = "account number")
    @Result(name = "num", value = "apidoccandy.@email.com", desc = "account number")
    private String num;

    @Param(name = "pass", required = true, desc = "password")
    @Result(name = "pass", value = "apidoccandy", desc = "password")
    private String pass;

    @Param(name = "name", required = true, desc = "ser name")
    @Result(name = "name", value = "apidoccandy", desc = "user name")
    private String name;

}
