package org.springframework.boot.encrypt;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtils {

    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static final String KEY_RAW = "redis-testencrup";

    // 获取 cipher
    private static Cipher getCipher(byte[] key, int model) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(model, secretKeySpec);
        return cipher;
    }

    // AES加密
    public static String encrypt(byte[] data) throws Exception {
        Cipher cipher = getCipher(KEY_RAW.getBytes(), Cipher.ENCRYPT_MODE);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data));
    }

    // AES解密
    public static byte[] decrypt(byte[] data) throws Exception {
        Cipher cipher = getCipher(KEY_RAW.getBytes(), Cipher.DECRYPT_MODE);
        return cipher.doFinal(Base64.getDecoder().decode(data));
    }

    public static void main(String[] args) throws Exception{
        String encrptMessage = "{\"id\": \"d67ee6eb-009a-4369-ac73-1534700a70d4\",\"name\": \"test2\"}";

        System.out.println(encrypt(encrptMessage.getBytes()));

    }
}
