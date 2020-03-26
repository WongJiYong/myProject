package com.xuersheng.myProject.web;

import com.xuersheng.myProject.util.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SecurityController {

    @GetMapping("/hello")
    public ResponseEntity<Object> hello() {
        return ResponseBuilder.success("you are authenticated");
    }

    @GetMapping("/csrf")
    public ResponseEntity<Object> csrf(CsrfToken token) {
        return ResponseBuilder.success(token);
    }

}
