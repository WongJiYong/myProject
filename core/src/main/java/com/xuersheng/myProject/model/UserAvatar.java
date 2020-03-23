package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * table user_avatar
 */
@Setter
@Getter
public class UserAvatar {

    /**
     * @mbg.generated
     */
    private Long id;

    /**
     * 真实文件名
     *
     * @mbg.generated
     */
    private String realName;

    /**
     * 路径
     *
     * @mbg.generated
     */
    private String path;

    /**
     * 大小
     *
     * @mbg.generated
     */
    private String size;

    /**
     * 创建时间
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
