package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * table job
 */
@Setter
@Getter
public class Job {

    /**
     * ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 岗位名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 岗位状态
     *
     * @mbg.generated
     */
    private Boolean enabled;

    /**
     * 岗位排序
     *
     * @mbg.generated
     */
    private Long sort;

    /**
     * 部门ID
     *
     * @mbg.generated
     */
    private Long deptId;

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
