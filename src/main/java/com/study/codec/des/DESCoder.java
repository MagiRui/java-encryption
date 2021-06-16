package com.study.codec.des;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public abstract class DESCoder {

  public static final String KEY_ALGORITHM = "DES";

  public static final String CIPHER_ALGORITHM="DES/ECB/PKCS5Padding";

  private static Key toKey(byte[] key) throws Exception{

    //实例化DES秘钥材料
    DESKeySpec dks = new DESKeySpec(key);

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
     * 实例化秘钥生成器
     * 若要使用64位秘钥注意替换
     * 将下述daim代码中的
     * KeyGenerator.getInstance(CIPHER_ALGORITHM)
     * 替换为
     * KeyGenerator.getInstance(CIPHER_ALGORITHM, "BC")
     * “BC”是BoucyCalstle安全提供者的缩写。
     **/
    KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);

    /**
     * 初始化秘钥生成器
     * 若要使用64为秘钥注意替换
     * 将下述代码kg.init(56)
     * 替换为kg.init(64)
     * 如果我们初始化密钥生成器时按如下方式实现，
     * 将获得一个默认长度的密钥：
     * kg.init(new SecureRandom())
     */

    kg.init(56);
    SecretKey secretKey = kg.generateKey();
    return secretKey.getEncoded();
  }



}
