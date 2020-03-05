package com.xuersheng.myProject.util;

import com.xuersheng.myProject.exception.AlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 对称加密 AES工具类
 */
public class AESUtils {

    private static Logger logger = LoggerFactory.getLogger(AESUtils.class);

    protected static String ALGORITHM = "AES";

    /**
     * 加密方法
     * @param text 将要加密的文本
     * @param encryptKey 加密的密码
     * @return 加密后的密文
     */
    public static byte[] encryptText(String text, String encryptKey) throws AlgorithmException {

        SecretKey originalKey = new SecretKeySpec(encryptKey.getBytes(StandardCharsets.UTF_8), 0, encryptKey.length(), ALGORITHM);
        try {
            Cipher aesCipher = Cipher.getInstance(ALGORITHM);
            aesCipher.init(Cipher.ENCRYPT_MODE, originalKey);
            return aesCipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            logger.error("加密出现异常", e);
            throw new AlgorithmException("加密出现异常");
        }
    }

    /**
     * 解密方法
     * @param encryptedText 加密后的文本
     * @param decryptedKey 解密的密码
     * @return 原始文本
     */
    public static String decryptText(byte[] encryptedText, String decryptedKey) throws AlgorithmException {
        SecretKey originalKey = new SecretKeySpec(decryptedKey.getBytes(StandardCharsets.UTF_8), 0,decryptedKey.length(), ALGORITHM);
        try {
            Cipher aesCipher = Cipher.getInstance(ALGORITHM);
            aesCipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] bytes = aesCipher.doFinal(encryptedText);
            return new String(bytes);
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            logger.error("解密出现异常", e);
            throw new AlgorithmException("解密出现异常");
        }
    }
}
