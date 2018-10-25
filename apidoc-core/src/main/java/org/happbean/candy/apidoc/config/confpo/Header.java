package org.happbean.candy.apidoc.config.confpo;

import lombok.Data;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
@Data
public class Header {

    private int id;

    private int actionId;

    private String name;

    private String required;

    private String desc;
}
