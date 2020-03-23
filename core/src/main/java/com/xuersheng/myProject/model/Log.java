package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * table log
 */
@Setter
@Getter
public class Log {

    /**
     * @mbg.generated
     */
    private Long id;

    /**
     * @mbg.generated
     */
    private Date createTime;

    /**
     * @mbg.generated
     */
    private String description;

    /**
     * @mbg.generated
     */
    private String logType;

    /**
     * @mbg.generated
     */
    private String method;

    /**
     * @mbg.generated
     */
    private String requestIp;

    /**
     * @mbg.generated
     */
    private Long time;

    /**
     * @mbg.generated
     */
    private String username;

    /**
     * @mbg.generated
     */
    private String address;

    /**
     * @mbg.generated
     */
    private String browser;

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

    /**
     * @mbg.generated
     */
    private String exceptionDetail;

    /**
     * @mbg.generated
     */
    private String params;
}
