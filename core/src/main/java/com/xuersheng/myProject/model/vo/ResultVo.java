package com.xuersheng.myProject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo<T> {

    private boolean success;

    private int code;

    private T data;
}
