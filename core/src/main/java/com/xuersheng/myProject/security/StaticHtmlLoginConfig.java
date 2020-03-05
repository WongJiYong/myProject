package com.xuersheng.myProject.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.PrintWriter;

public class StaticHtmlLoginConfig<T extends AbstractHttpConfigurer<T, B>, B extends HttpSecurityBuilder<B>>
        extends AbstractHttpConfigurer<T, B> {


    private UsernamePasswordAuthenticationFilter authFilter;

    public StaticHtmlLoginConfig() {
        this.authFilter = new UsernamePasswordAuthenticationFilter();
    }

    //default "/login", "POST"
    public StaticHtmlLoginConfig requestUrl(String url, String method) {
        authFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(url, method));
        return this;
    }

    public StaticHtmlLoginConfig usernameParameter(String usernameParameter) {
        authFilter.setUsernameParameter(usernameParameter);
        return this;
    }

    public StaticHtmlLoginConfig passwordParameter(String passwordParameter) {
        authFilter.setPasswordParameter(passwordParameter);
        return this;
    }


    @Override
    public void configure(B builder) throws Exception {
        UsernamePasswordAuthenticationFilter authFilter = new UsernamePasswordAuthenticationFilter();
        authFilter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));

        authFilter.setAuthenticationSuccessHandler((request, response, authentication) -> {
            // 返回成功
            response.setStatus(HttpStatus.OK.value());
            String resp = "{\"code\":200,\"data\":null,\"success\":true}";
            PrintWriter writer = response.getWriter();
            writer.print(resp);
            writer.flush();
            response.flushBuffer();
        });
        authFilter.setAuthenticationFailureHandler((request, response, exception) -> {
            //授权失败
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            String resp = "{\"code\":401,\"data\":null,\"success\":false}";
            PrintWriter writer = response.getWriter();
            writer.print(resp);
            writer.flush();
            response.flushBuffer();
        });
        AuthenticationDetailsSource authenticationDetailsSource = builder.getSharedObject(AuthenticationDetailsSource.class);
        if (authenticationDetailsSource != null) {
            authFilter.setAuthenticationDetailsSource(authenticationDetailsSource);
        } else {
            authFilter.setAuthenticationDetailsSource(new WebAuthenticationDetailsSource());
        }
        SessionAuthenticationStrategy sessionAuthenticationStrategy = builder.getSharedObject(SessionAuthenticationStrategy.class);
        if (sessionAuthenticationStrategy != null) {
            authFilter.setSessionAuthenticationStrategy(sessionAuthenticationStrategy);
        }
        RememberMeServices rememberMeServices = builder.getSharedObject(RememberMeServices.class);
        if (rememberMeServices != null) {
            authFilter.setRememberMeServices(rememberMeServices);
        }
        authFilter = postProcess(authFilter);
        builder.addFilter(authFilter);
    }

}
