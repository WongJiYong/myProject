package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * table local_storage
 */
@Setter
@Getter
public class LocalStorage {

    /**
     * @mbg.generated
     */
    private Long id;

    /**
     * 文件真实的名称
     *
     * @mbg.generated
     */
    private String realName;

    /**
     * 文件名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 后缀
     *
     * @mbg.generated
     */
    private String suffix;

    /**
     * 路径
     *
     * @mbg.generated
     */
    private String path;

    /**
     * 类型
     *
     * @mbg.generated
     */
    private String type;

    /**
     * 大小
     *
     * @mbg.generated
     */
    private String size;

    /**
     * 操作人
     *
     * @mbg.generated
     */
    private String operate;

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
