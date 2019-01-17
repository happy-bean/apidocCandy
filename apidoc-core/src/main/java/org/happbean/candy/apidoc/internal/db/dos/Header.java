package org.happbean.candy.apidoc.internal.db.dos;


/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public class Header extends ApiDbObject {

    private long id;

    private long actionId;

    private String name;

    private String required;

    private String desc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
