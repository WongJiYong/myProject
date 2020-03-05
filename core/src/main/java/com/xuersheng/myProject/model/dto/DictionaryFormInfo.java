package com.xuersheng.myProject.model.dto;

import java.util.StringJoiner;

public class DictionaryFormInfo {

    private Integer id;

    private String name;

    private String value;

    private Boolean valid;

    private String comment;

    private Integer parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", DictionaryFormInfo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("value='" + value + "'")
                .add("valid=" + valid)
                .add("comment='" + comment + "'")
                .add("parentId=" + parentId)
                .toString();
    }
}
