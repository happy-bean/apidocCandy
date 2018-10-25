package org.happbean.candy.apidoc.config.confpo;

import lombok.Data;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
@Data
public class Param {

    private int id;

    private int actionId;

    private String name;

    private String type;

    private String required;

    private String desc;

    private int lastId;
}
