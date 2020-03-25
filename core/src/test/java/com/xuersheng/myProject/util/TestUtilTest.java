package com.xuersheng.myProject.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Slf4j
public class TestUtilTest {

    @Test
    public void randomObject() {
    }

    @Test
    public void randomValue() {
    }

    @Test
    public void equalsObjs() {
    }

    @Test
    public void obj2UrlParams() throws UnsupportedEncodingException {
        Abc child = new Abc("11", 22, 33L, null, false, null);
        Abc parent = new Abc("1", 2, 3L, null, true, child);

        String s = TestUtil.obj2UrlParams(parent);
        String s2 = "?abc.c1=11&abc.c2=22&abc.c3=33&abc.c5=false&c1=1&c2=2&c3=3&c5=true";

        assert s2.equals(s);
        Abc cc = new Abc();
        cc.setC4(new Date());
        s = TestUtil.obj2UrlParams(cc);
        Assert.isTrue(StringUtils.hasText(s), "s not empty");
        log.info(s);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Abc {
        private String c1;
        private Integer c2;
        private Long c3;
        private Date c4;
        private Boolean c5;
        private Abc abc;
    }
}