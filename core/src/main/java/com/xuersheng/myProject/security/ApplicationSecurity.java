package com.xuersheng.myProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Resource
    UserDetailsServiceImpl systemUserDetailsService;

    @Autowired
    public void initialize(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(systemUserDetailsService).passwordEncoder(new BCryptPasswordEncoder())
                .and().eraseCredentials(true);
    }

    @Resource
    ElasticUrlDecisionVoter elasticUrlDecisionVoter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        List<AccessDecisionVoter<?>> decisionVoters = new ArrayList<>();
        decisionVoters.add(new WebExpressionVoter());
        decisionVoters.add(elasticUrlDecisionVoter);

        http
                .csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                .and()
                //使用username password 授权
                .apply(new StaticHtmlLoginConfig<>())
                .and()
                .rememberMe().key("shuiJiShu").rememberMeParameter("rememberMe").tokenValiditySeconds(7 * 24 * 3600)
                .and()
                .logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .and()
                //批准请求
                .authorizeRequests()
                //允许所有请求获取csrf token
                .antMatchers("/csrf").permitAll()
                // 所有授权的都可以访问
                .antMatchers("/user/info", "/hello").authenticated()
                // 其他所有请求都拒绝
                .anyRequest().denyAll()
                .accessDecisionManager(new AffirmativeBased(decisionVoters))
                .and().exceptionHandling()
                .accessDeniedHandler(new AccessDeniedExceptionHandler())
                .authenticationEntryPoint(new CusAuthenticationEntryPoint());
    }


    public static class AccessDeniedExceptionHandler implements AccessDeniedHandler {

        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
            buildExceptionResponse(response, accessDeniedException);
        }
    }

    public static class CusAuthenticationEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
            buildExceptionResponse(response, authException);
        }
    }

    private static void buildExceptionResponse(HttpServletResponse response, Exception authException) throws IOException {
        if (!response.isCommitted()) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
            PrintWriter writer = response.getWriter();
            String sb = "{\"success\":" + false + "," +
                    "\"code\":" + HttpStatus.FORBIDDEN.value() + "," +
                    "\"data\":\"" + authException.getMessage() + "\"" +
                    "}";
            writer.print(sb);
            writer.flush();
            response.flushBuffer();
        }
    }

}
