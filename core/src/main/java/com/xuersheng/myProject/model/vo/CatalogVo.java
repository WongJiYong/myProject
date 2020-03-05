package com.xuersheng.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CatalogVo {
    private Integer id;

    private String name;

    private String type;

    private Integer parentId;

    private Integer seq;
}
