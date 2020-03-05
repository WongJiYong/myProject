package com.xuersheng.myProject.model.base;

public class BaseProcessInfo {
    private Integer id;

    private Integer serverId;

    private Integer pid;

    private String name;

    private Integer port;

    private String detail;

    private String rootPath;

    private String startupSh;

    private String shutdownSh;

    private String status;

    private Boolean deleted;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath == null ? null : rootPath.trim();
    }

    public String getStartupSh() {
        return startupSh;
    }

    public void setStartupSh(String startupSh) {
        this.startupSh = startupSh == null ? null : startupSh.trim();
    }

    public String getShutdownSh() {
        return shutdownSh;
    }

    public void setShutdownSh(String shutdownSh) {
        this.shutdownSh = shutdownSh == null ? null : shutdownSh.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}