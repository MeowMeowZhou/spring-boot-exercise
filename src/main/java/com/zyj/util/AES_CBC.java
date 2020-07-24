package com.zyj.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES/CBC/PKCS5Padding 对称加密
 *
 * @Author 朱兴邦
 * @CreateDate: 2020/3/23 10:23
 */
public class AES_CBC {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * 数据加密
     *
     * @param srcData
     * @param key
     * @param iv
     * @return
     */
    public static String encrypt(String srcData, byte[] key, byte[] iv) {
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher;
        String encodeBase64String = null;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv));
            byte[] encData = cipher.doFinal(srcData.getBytes("UTF-8"));
            encodeBase64String = Base64.encodeBase64String(encData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodeBase64String;
    }

    /**
     * 数据解密
     *
     * @param encDataStr
     * @param key
     * @param iv
     * @return
     */
    public static String decrypt(String encDataStr, byte[] key, byte[] iv) {
        byte[] encData = Base64.decodeBase64(encDataStr);
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher;
        byte[] decbbdt = null;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));
            decbbdt = cipher.doFinal(encData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(decbbdt);
    }

}
