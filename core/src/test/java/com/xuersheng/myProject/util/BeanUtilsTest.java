package com.xuersheng.myProject.util;

import lombok.Data;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BeanUtilsTest {

    @Test
    public void copyPropertiesDeeply() {
        Source s = new Source();
        s.setA("1");
        Source s2 = new Source();
        s2.setA("2");
        Source s3 = new Source();
        s3.setA("3");
        s.setS(s2);
        s.setStr(Collections.singletonList("str"));
        s.setLs(Collections.singletonList(s3));
        Target t = new Target();
        BeanUtils.copyPropertiesDeeply(s, t);
        System.out.println(t);
    }

    @Data
    static class Source {
        private String a;
        private Source s;
        private List<String> str;
        private List<Source> ls;

    }

    @Data
    static class Target {

        private String a;
        private Target s;
        private List<String> str;
        private List<Target> ls;

    }
}



