package com.xuersheng.myProject.web;

import com.xuersheng.myProject.SystemApplication;
import com.xuersheng.myProject.ThreadBox;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = SystemApplication.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public abstract class BaseControllerTest {

    protected MockMvc mvc;

    public BaseControllerTest() {
        ThreadBox.setDatasourceKey("default");
    }

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    protected JacksonTester<Object> json;

    /*
     * @MockBean 可以使用虚假得service bean
     */
    @Before
    public void beforeEachTestMethod() throws Exception {
        log.error("设置默认的数据源路由编码");
        ThreadBox.setDatasourceKey("default");
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        mvc.perform(formLogin("/login").user("admin").password("123456")
                .acceptMediaType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
        mvc.perform(get("/hello")
                .with(user("admin").roles("admin"))
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @After
    public void after() {

    }

}
