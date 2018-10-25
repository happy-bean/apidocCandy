package org.happbean.candy.apidoc.demo;

import lombok.Data;
import org.happbean.candy.apidoc.factory.annotation.response.Result;

/**
 * @author wgt
 * @date 2018-09-15
 * @description
 **/
@Data
@Result
public class User {

    @Result(name = "num", value = "apidoccandy.@email.com", desc = "account number")
    private String num;

    @Result(name = "pass", value = "apidoccandy", desc = "password")
    private String pass;

    @Result(name = "name", value = "apidoccandy", desc = "user name")
    private String name;

}
