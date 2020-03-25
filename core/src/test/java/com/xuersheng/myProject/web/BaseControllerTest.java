package com.xuersheng.myProject.web;

import com.xuersheng.myProject.SystemApplication;
import com.xuersheng.myProject.ThreadBox;
import com.xuersheng.myProject.model.vo.ResultVo;
import com.xuersheng.myProject.util.TestUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Autowired
    protected JacksonTester<ResultVo<Object>> resutVo;

    /*
     * @MockBean 可以使用虚假得service bean
     */
    @Before
    public void beforeEachTestMethod() throws Exception {
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
        log.info("hello world");
    }

    @After
    public void after() {

    }

    protected String httpPost(String url, Object jsonObj) throws Exception {
        String content = this.mvc.perform(
                post(url)
                        .with(csrf().asHeader())
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json.write(jsonObj).getJson())
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        ResultVo<Object> object = resutVo.parse(content).getObject();
        log.info("code:{}:data:{}", object.getCode(), object.getData());
        return content;
    }

    protected String httpGet(String url, Object mapObject) throws Exception {
        url += TestUtil.obj2UrlParams(mapObject);
        String content = this.mvc.perform(
                get(url).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        ResultVo<Object> object = resutVo.parse(content).getObject();
        log.info("code:{}:data:{}", object.getCode(), object.getData());
        return content;
    }

}
