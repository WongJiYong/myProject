package com.xuersheng.myProject.model.base;

import java.util.Date;

public class BaseServerInfo {
    private Integer id;

    private String ip;

    private String name;

    private Integer type;

    private String detail;

    private String username;

    private String password;

    private Integer catalogId;

    private Date modifiedTime;

    private Boolean connectable;

    private String mountedOn;

    private Integer diskTotal;

    private Integer diskUsed;

    private Date updateTime;

    private Boolean deleted;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean getConnectable() {
        return connectable;
    }

    public void setConnectable(Boolean connectable) {
        this.connectable = connectable;
    }

    public String getMountedOn() {
        return mountedOn;
    }

    public void setMountedOn(String mountedOn) {
        this.mountedOn = mountedOn == null ? null : mountedOn.trim();
    }

    public Integer getDiskTotal() {
        return diskTotal;
    }

    public void setDiskTotal(Integer diskTotal) {
        this.diskTotal = diskTotal;
    }

    public Integer getDiskUsed() {
        return diskUsed;
    }

    public void setDiskUsed(Integer diskUsed) {
        this.diskUsed = diskUsed;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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