package com.xuersheng.myProject.model;

import lombok.Getter;
import lombok.Setter;

/**
 * table catalog
 */
@Setter
@Getter
public class Catalog {

    /**
     * 主键
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 目录名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 类型
     *
     * @mbg.generated
     */
    private String type;

    /**
     * 父目录id
     *
     * @mbg.generated
     */
    private Integer parentId;

    /**
     * 顺序
     *
     * @mbg.generated
     */
    private Integer seq;

    /**
     * 逻辑删除位
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     * 版本号
     *
     * @mbg.generated
     */
    private Integer version;
}
