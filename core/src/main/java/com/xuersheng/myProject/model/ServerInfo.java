package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * table server_info
 */
@Setter
@Getter
public class ServerInfo {

    /**
     * 主键
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * ip
     *
     * @mbg.generated
     */
    private String ip;

    /**
     * 服务器名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 类型
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     * @mbg.generated
     */
    private String detail;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    private String username;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 目录id
     *
     * @mbg.generated
     */
    private Integer catalogId;

    /**
     * 最后修改时间
     *
     * @mbg.generated
     */
    private Date modifiedTime;

    /**
     * 可连接
     *
     * @mbg.generated
     */
    private Boolean connectable;

    /**
     * 挂载点
     *
     * @mbg.generated
     */
    private String mountedOn;

    /**
     * 磁盘总量
     *
     * @mbg.generated
     */
    private Integer diskTotal;

    /**
     * 磁盘已使用
     *
     * @mbg.generated
     */
    private Integer diskUsed;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private Date updateTime;

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
