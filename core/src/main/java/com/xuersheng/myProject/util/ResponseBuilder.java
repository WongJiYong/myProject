package com.xuersheng.myProject.util;

import com.xuersheng.myProject.model.vo.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ResponseBuilder {

    public static final String MODIFY_ERROR = "修改数据失败";
    public static final String ADD_ERROR = "添加数据失败";
    public static final String REMOVE_ERROR = "删除数据失败";

    /**
     * @param body 失败请求返回信息
     * @return ResponseEntity
     */
    public static ResponseEntity<Object> error(Object body) {
        ResultVo<Object> vo = new ResultVo<>(false, HttpStatus.BAD_REQUEST.value(), body);
        return new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Object> error() {
        return error(null);
    }

    /**
     * @param body 成功请求返回信息
     * @return ResponseEntity
     */
    public static ResponseEntity<Object> success(Object body) {
        ResultVo<Object> vo = new ResultVo<>(true, HttpStatus.OK.value(), body);
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

    public static ResponseEntity<Object> success() {
        return success(null);
    }
}
