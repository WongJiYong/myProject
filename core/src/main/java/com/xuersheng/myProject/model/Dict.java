package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * table dict
 */
@Setter
@Getter
public class Dict {

    /**
     * @mbg.generated
     */
    private Long id;

    /**
     * 字典名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 描述
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date createTime;

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
