package org.happbean.candy.apidoc.demo;

import org.happbean.candy.apidoc.internal.annotation.request.Param;
import org.happbean.candy.apidoc.internal.annotation.response.Result;

/**
 * @author wgt
 * @date 2018-09-15
 * @description
 **/
@Result(name = "user",value = "user",desc = "user info")
public class User {

    @Param(name = "num", required = true, desc = "account number")
    @Result(name = "num", value = "apidoccandy.@email.com", desc = "account number")
    private String num;

    @Param(name = "pass", required = true, desc = "password")
    @Result(name = "pass", value = "apidoccandy", desc = "password")
    private String pass;

    @Param(name = "name", required = true, desc = "user name")
    @Result(name = "name", value = "apidoccandy", desc = "user name")
    private String name;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
