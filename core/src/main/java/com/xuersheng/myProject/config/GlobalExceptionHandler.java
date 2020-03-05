package com.xuersheng.myProject.config;

import com.xuersheng.myProject.model.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity accessDeniedException(AccessDeniedException e) {
        ResultVo<Object> resultVo = new ResultVo<>(false,
                HttpStatus.UNAUTHORIZED.value(),
                e.getMessage());
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(resultVo, HttpStatus.UNAUTHORIZED);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandler(Exception e) {
        ResultVo<Object> resultVo = new ResultVo<>(false,
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage());
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(resultVo, HttpStatus.BAD_REQUEST);
    }
}