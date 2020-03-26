package com.xuersheng.util;

import com.xuersheng.exception.DecryptException;
import com.xuersheng.exception.EncryptException;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.Assert.assertEquals;

@Slf4j
public class AESUtilsTest {

    @org.junit.Test
    public void exe() throws EncryptException, DecryptException {
        // 原文:
        String text = "Hello, world!这是汉字";

        System.out.println("Message: " + text);
        byte[] key = AESUtils.randomKey(192);
        // 加密:
        String encryptedText = AESUtils.encryptText(text, key);
        String keyStr = new String(Base64.getEncoder().encode(key),StandardCharsets.UTF_8);
        System.out.println();
        // 解密:
        String decrypted = AESUtils.decryptText(encryptedText, keyStr);
        log.info(decrypted);
        assertEquals(decrypted, text);
    }

    @org.junit.Test
    public void decryptText() {
    }

}