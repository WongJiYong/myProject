package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * table dict_detail
 */
@Setter
@Getter
public class DictDetail {

    /**
     * @mbg.generated
     */
    private Long id;

    /**
     * 字典标签
     *
     * @mbg.generated
     */
    private String label;

    /**
     * 字典值
     *
     * @mbg.generated
     */
    private String value;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private String sort;

    /**
     * 字典id
     *
     * @mbg.generated
     */
    private Long dictId;

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
