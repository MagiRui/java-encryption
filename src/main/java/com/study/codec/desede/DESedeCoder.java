package com.study.codec.desede;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class DESedeCoder {

  /**
   * 密钥算法
   * Java7支持密钥长度为112位和168位
   * BouncyCastle支持密钥长度为128位和192位
   */
  public static final String KEY_ALGORITHM = "DESede";

  /**
   *   加密/解密算法/工作模式/填充方式
   *   Java7支持PKCS5Padding填充方式
   *   BouncyCastle支持PKCS7Padding填充方式
   */
  public static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

  private static Key toKey(byte[] key) throws Exception{

    //实例化DES秘钥材料
    DESedeKeySpec dks = new DESedeKeySpec(key);

    //实例化秘钥要是工厂
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
    //生成私密秘钥
    SecretKey secretKey = keyFactory.generateSecret(dks);
    return secretKey;
  }

  public static byte[] decrypt(byte[] data, byte[] key)
      throws Exception {

    //还原秘钥
    Key k = toKey(key);
    //实例化
    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
    //初始化，设置为解密模式
    cipher.init(Cipher.DECRYPT_MODE, k);

    return cipher.doFinal(data);
  }

  public static byte[] encrypt(byte[] data, byte[] key)
      throws Exception {

    //还原秘钥
    Key k = toKey(key);

    //实例化
    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
    //初始化, 设置为加密模式
    cipher.init(Cipher.ENCRYPT_MODE, k);

    return cipher.doFinal(data);
  }

  public static byte[] initKey() throws Exception{


    /**
     * 实例化
     * 使用128位或192位长度秘钥,按如下代码实现
     * 将下述daim代码中的
     * KeyGenerator.getInstance(KEY_ALGORITHM, "BC")
     **/
    KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);

    /**
     * 初始化秘钥生成器
     * 若使用128位或192位长度秘钥,按如下代码实现:
     * kg.init(128)
     * 或
     * kg.init(192)
     */

    kg.init(168);
    SecretKey secretKey = kg.generateKey();
    return secretKey.getEncoded();
  }

}
