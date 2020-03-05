package com.xuersheng.myProject.model.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ServerInfoParamsDto {

    private String ip;
    private String name;
    private String detail;

    @NotNull(message = "参数不能为空")
    private Boolean useCatalog;

    @NotNull(message = "参数不能为空")
    private List<Integer> catalogIds;
    private PageDto pageData;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getUseCatalog() {
        return useCatalog;
    }

    public void setUseCatalog(Boolean useCatalog) {
        this.useCatalog = useCatalog;
    }

    public List<Integer> getCatalogIds() {
        return catalogIds;
    }

    public void setCatalogIds(List<Integer> catalogIds) {
        this.catalogIds = catalogIds;
    }

    public PageDto getPageData() {
        return pageData;
    }

    public void setPageData(PageDto pageData) {
        this.pageData = pageData;
    }

}
