package org.happbean.candy.apidoc.config.confpo;

import lombok.Data;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
@Data
public class Action {

    private int id;

    private String name;

    private String path;

    private String method;

    private String desc;
}
