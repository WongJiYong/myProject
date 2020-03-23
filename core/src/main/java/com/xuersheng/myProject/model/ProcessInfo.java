package com.xuersheng.myProject.model;

import lombok.Getter;
import lombok.Setter;

/**
 * table process_info
 */
@Setter
@Getter
public class ProcessInfo {

    /**
     * 主键
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 外键
     *
     * @mbg.generated
     */
    private Integer serverId;

    /**
     * 进程pid
     *
     * @mbg.generated
     */
    private Integer pid;

    /**
     * 进程名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 端口
     *
     * @mbg.generated
     */
    private Integer port;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String detail;

    /**
     * 根路径
     *
     * @mbg.generated
     */
    private String rootPath;

    /**
     * 启动脚本
     *
     * @mbg.generated
     */
    private String startupSh;

    /**
     * 关闭路径
     *
     * @mbg.generated
     */
    private String shutdownSh;

    /**
     * 进程状态
     *
     * @mbg.generated
     */
    private String status;

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
