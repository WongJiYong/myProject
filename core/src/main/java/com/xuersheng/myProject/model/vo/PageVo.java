package com.xuersheng.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PageVo {

    private long total;

    private int pageNum;

    private List<?> data;
}
