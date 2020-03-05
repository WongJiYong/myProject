package com.xuersheng.myProject.model.dto;

public class PageDto {

    private Integer pageSize;

    private Integer currentPage;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer startIndex(){
        if (currentPage==null || currentPage < 1){
            currentPage = 1;
        }
        return  (currentPage - 1) * getPageSize();
    };

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1){
            pageSize = 10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
