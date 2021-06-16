package com.study.codec.pbe;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class PBECoder {

  public static final String ALGORITHM = "PBEWITHMD5ANDDES";

  /**
   * 迭代次数
   */
  public static final int ITERAtION_COUNT = 100;

  /**
   * 盐初始化
   * 盐长度必须为8字节
   *
   */

  public static byte[] initSalt() throws Exception{

    SecureRandom random = new SecureRandom();
    return random.generateSeed(8);
  }

  private static Key toKey(String pwd) throws Exception{

    PBEKeySpec keySpec = new PBEKeySpec(pwd.toCharArray());
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
    SecretKey secretKey = keyFactory.generateSecret(keySpec);
    return secretKey;
  }

  public static byte[] encrypt(byte[] data, String pwd, byte[] salt)
    throws Exception {

    Key key = toKey(pwd);
    PBEParameterSpec parameterSpec =
        new PBEParameterSpec(salt, ITERAtION_COUNT);
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
    return cipher.doFinal(data);
  }

  public static byte[] decrypt(byte[] data, String pwd, byte[] salt)
  throws Exception{

    Key key = toKey(pwd);
    PBEParameterSpec parameterSpec =
        new PBEParameterSpec(salt, ITERAtION_COUNT);
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
    return cipher.doFinal(data);
  }
}
