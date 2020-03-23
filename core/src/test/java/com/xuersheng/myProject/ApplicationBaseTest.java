package com.xuersheng.myProject;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemApplication.class)
public abstract class ApplicationBaseTest {

    public ApplicationBaseTest() {
        ThreadBox.setDatasourceKey("default");
    }

    @Before
    protected void loginSystem(){
        log.debug("loginSystem");
    }
}
