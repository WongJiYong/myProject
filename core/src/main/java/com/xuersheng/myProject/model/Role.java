package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * table role
 */
@Setter
@Getter
public class Role {

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
     * 编码
     *
     * @mbg.generated
     */
    private String code;

    /**
     * 备注
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
     * 是否锁定
     *
     * @mbg.generated
     */
    private Boolean locked;

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

    private List<Long> menuIds;

    private List<Long> actionIds;
}
