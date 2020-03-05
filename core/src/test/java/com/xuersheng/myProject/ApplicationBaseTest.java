package com.xuersheng.myProject;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemApplication.class)
public abstract class ApplicationBaseTest {

    public ApplicationBaseTest() {
        ThreadBox.setDatasourceKey("default");
    }

}
