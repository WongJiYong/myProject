package com.xuersheng.myProject.util;

import com.github.pagehelper.Page;
import com.xuersheng.myProject.model.vo.PageVo;

import java.util.List;

public abstract class PageBuilder {

    public static <T> PageVo<T> builder(List<T> data, Page<?> page) {
        PageVo<T> pageVo = new PageVo<>();
        pageVo.setData(data);
        pageVo.setTotal(page.getTotal());
        pageVo.setPageNum(page.getPageNum());
        return pageVo;
    }
}
