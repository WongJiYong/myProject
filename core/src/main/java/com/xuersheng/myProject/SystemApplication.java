package com.xuersheng.myProject;

import com.xuersheng.myProject.util.ResponseBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.xuersheng")
@MapperScan({"com.xuersheng.myProject.mapper"})
@RestController("/")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

    @GetMapping("/hello")
    public ResponseEntity<Object> hello() {
        return ResponseBuilder.success("you are authenticated");
    }

    @GetMapping("/csrf")
    public ResponseEntity<Object> csrf(CsrfToken token) {
        return ResponseBuilder.success(token);
    }

}
