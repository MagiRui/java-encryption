package com.study.codec.aes;

import java.security.Key;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class BouncyCastleAESCoder {

  public static final String KEY_ALGORITHM="AES";

  /**
   * 加密/解密算法/工作模式/填充方式
   */
  public static final String CIPHER_ALGORITHM="AES/ECB/PKCS5Padding";

  private static Key toKey(byte[] key) throws Exception{

    //实例化AES秘钥材料
    SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);

    return secretKey;
  }

  public static byte[] decrypt(byte[] data, byte[] key) throws Exception {

    Key k = toKey(key);
    /**
     * 实例化
     * 使用PKCS7Padding填充方式,按如下方式实现:
     * Cipher.getInstance(CIPHER_ALGORITHM, "BC")
     */
    Security.addProvider(new BouncyCastleProvider());
    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
    cipher.init(Cipher.DECRYPT_MODE, k);
    return cipher.doFinal(data);
  }

  public static byte[] encrypt(byte[] data,
      byte[] key) throws Exception {

    //还原秘钥
    Key k = toKey(key);

    /**
     * 实例化
     * 使用PKCS7Padding填充方式,按如下方式实现：
     * Cipher.getInstance(CIPHER_ALGORITHM, "BC")
     */

     Security.addProvider(new BouncyCastleProvider());
     Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
     cipher.init(Cipher.ENCRYPT_MODE, k);
     return cipher.doFinal(data);
  }

  public static byte[] initKey()throws Exception{

    KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
    //AES要求秘钥长度为128位,192位或256位
    kg.init(256);
    //生成私密秘钥
    SecretKey secretKey = kg.generateKey();
    return secretKey.getEncoded();
  }
}
