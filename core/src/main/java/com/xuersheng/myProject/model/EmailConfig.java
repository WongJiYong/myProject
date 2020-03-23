package com.xuersheng.myProject.model;

import lombok.Getter;
import lombok.Setter;

/**
 * table email_config
 */
@Setter
@Getter
public class EmailConfig {

    /**
     * ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 收件人
     *
     * @mbg.generated
     */
    private String fromUser;

    /**
     * 邮件服务器SMTP地址
     *
     * @mbg.generated
     */
    private String host;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String pass;

    /**
     * 端口
     *
     * @mbg.generated
     */
    private String port;

    /**
     * 发件者用户名
     *
     * @mbg.generated
     */
    private String user;

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
