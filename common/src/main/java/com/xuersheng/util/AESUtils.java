package com.xuersheng.util;

import com.xuersheng.exception.DecryptException;
import com.xuersheng.exception.EncryptException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

/**
 * 对称加密 AES工具类
 */
public class AESUtils {

    /**
     * @param text 明文
     * @param key  密钥
     * @return 密文
     * @throws EncryptException 加密失败
     */
    public static byte[] encryptText(byte[] text, byte[] key) throws EncryptException {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey keySpec = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException ignore) {
        }
        assert cipher != null;
        try {
            return cipher.doFinal(text);
        } catch (Exception e) {
            throw new EncryptException();

        }
    }

    /**
     * @param text 密文
     * @param key  密钥
     * @return 明文
     * @throws DecryptException 解密失败
     */
    public static byte[] decryptText(byte[] text, byte[] key) throws DecryptException {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey keySpec = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException ignore) {
        }
        assert cipher != null;
        try {
            return cipher.doFinal(text);
        } catch (Exception e) {
            throw new DecryptException();
        }
    }

    /**
     * AES 密钥长度为 128/192/256
     *
     * @param length 密钥长度 128/192/256
     * @return 随机密钥
     */
    public static byte[] randomKey(int length) {
        byte[] bytes = new byte[length / 8];
        new Random().nextBytes(bytes);
        return bytes;
    }

    /**
     * @param text 明文
     * @param key  密钥
     * @return base64编码的密文
     * @throws EncryptException 加密失败
     */
    public static String encryptText(String text, byte[] key) throws EncryptException {
        byte[] result = encryptText(text.getBytes(StandardCharsets.UTF_8), key);
        return new String(Base64.getEncoder().encode(result), StandardCharsets.UTF_8);
    }

    /**
     * @param text base64编码的密文
     * @param key  base64编码的密钥
     * @return 明文
     * @throws DecryptException 解密失败
     */
    public static String decryptText(String text, String key) throws DecryptException {
        byte[] textBytes = Base64.getDecoder().decode(text.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Base64.getDecoder().decode(key.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = decryptText(textBytes, keyBytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
