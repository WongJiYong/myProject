package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * table dept
 */
@Setter
@Getter
public class Dept {

    /**
     * ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 上级部门
     *
     * @mbg.generated
     */
    private Long pid;

    /**
     * 状态
     *
     * @mbg.generated
     */
    private Boolean enabled;

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
