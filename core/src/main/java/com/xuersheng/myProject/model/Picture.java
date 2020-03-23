package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * table picture
 */
@Setter
@Getter
public class Picture {

    /**
     * ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 上传日期
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 删除的URL
     *
     * @mbg.generated
     */
    private String deleteUrl;

    /**
     * 图片名称
     *
     * @mbg.generated
     */
    private String filename;

    /**
     * 图片高度
     *
     * @mbg.generated
     */
    private String height;

    /**
     * 图片大小
     *
     * @mbg.generated
     */
    private String size;

    /**
     * 图片地址
     *
     * @mbg.generated
     */
    private String url;

    /**
     * 用户名称
     *
     * @mbg.generated
     */
    private String username;

    /**
     * 图片宽度
     *
     * @mbg.generated
     */
    private String width;

    /**
     * 文件的MD5值
     *
     * @mbg.generated
     */
    private String md5code;

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
