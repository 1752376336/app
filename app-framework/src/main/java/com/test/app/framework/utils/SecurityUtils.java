package com.test.app.framework.utils;

import com.test.app.framework.exception.ServiceException;
import com.test.app.framework.metadata.consts.ResultCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.util.text.BasicTextEncryptor;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class SecurityUtils {
    private static final String COMMON_SECURITY_SALT = "QWER!@#$()";

    public SecurityUtils() {
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    public static String generateSalt(int len) {

        return byte2hex((new RandomSaltGenerator()).generateSalt(len));
    }

    public static String encrypt(String password) {
        return encrypt(password, "QWER!@#$()");
    }

    public static String decrypt(String password) {
        return decrypt(password, "QWER!@#$()");
    }

    public static String encrypt(String password, String salt) {
        if (password == null) {
            return null;
        } else {
            BasicTextEncryptor encrypt = new BasicTextEncryptor();
            encrypt.setPassword(salt);
            String encrypted = encrypt.encrypt(password);
            return encrypted;
        }
    }

    public static String decrypt(String password, String salt) {
        BasicTextEncryptor encrypt = new BasicTextEncryptor();
        encrypt.setPassword(salt);
        String encrypted = encrypt.decrypt(password);
        return encrypted;
    }

    public static String md5(String plan) {
        return DigestUtils.md5Hex(plan);
    }

    public static String sha512(String plan) {
        return DigestUtils.sha512Hex(plan);
    }


    /**
     * 公钥还原，适用于RSA算法
     *
     * @param rawKey 加密公钥 不含-------
     * @return base64后以RSA获取PublicKey
     * @throws Exception
     */
    private static PublicKey getRsaPublicKey(String rawKey) throws Exception {
        byte[] encodedKey = Encodes.decodeBase64(rawKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");//"RSA"="RSA/ECB/PKCS1Padding"
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;//通过公钥byte[](publicKey.getEncoded())将
    }

    public static String rsa(String content, String rsaPub) throws ServiceException {
        try {
            Key key = getRsaPublicKey(rsaPub);
            /** 得到Cipher对象来实现对源数据的RSA加密 */
            String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] sourceBytes = content.getBytes();
            /** 执行加密操作 不分段*/
            byte[] rsaEncrypt = cipher.doFinal(sourceBytes);
            return Encodes.encodeBase64(rsaEncrypt);
        } catch (Exception e) {
            throw new ServiceException(e).code(ResultCode.Default.ERROR_INNER);
        }
        /** 对数据分段加密 https://www.cnblogs.com/jiafuwei/p/7054500.html
         * int MAX_ENCRYPT_BLOCK = 117;
         Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
         cipher.init(Cipher.ENCRYPT_MODE, decodePublicKey);
         int inputLen = data.length;
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         int offSet = 0;
         byte[] cache;
         int i = 0;
         while (inputLen - offSet > 0) {
         if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
         cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
         } else {
         cache = cipher.doFinal(data, offSet, inputLen - offSet);
         }
         out.write(cache, 0, cache.length);
         i++;
         offSet = i * MAX_ENCRYPT_BLOCK;
         }
         byte[] encryptedData = out.toByteArray();
         out.close();
         String encodedDataStr = new String(Base64.encode(encryptedData));
         System.out.println("公钥加密后的数据:"+encodedDataStr);
         */
    }

//    public static void main(String[] args) {
//        System.out.println(decrypt("YERu1lQ2EvjpSJqt0r0Sfg==", "D1DBAE2B5B84"));
//    }
}