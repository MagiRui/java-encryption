package com.study.codec.mac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public abstract class MACCoder {

  public static byte[] initHmacMD5Key() throws Exception{

    //初始化KeyGenerator
    KeyGenerator keyGenerator =
        KeyGenerator.getInstance("HmacMD5");
    //产生秘钥
    SecretKey secretKey = keyGenerator.generateKey();
    //获得秘钥
    return secretKey.getEncoded();
  }

  public static byte[] encodeHmacMD5(byte[] data, byte[] key)
    throws Exception {

    //还原秘钥
    SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");

    //实例化Mac
    Mac mac = Mac.getInstance(secretKey.getAlgorithm());

    //初始化Mac
    mac.init(secretKey);

    //执行消息摘要
    return mac.doFinal(data);

  }

  public static byte[] initHmacSHAKey() throws Exception {

    //初始化KeyGenerator
    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA1");
    SecretKey secretKey = keyGenerator.generateKey();
    return secretKey.getEncoded();
  }

  public static byte[] encodeHmacSHA(byte[] data, byte[] key)
    throws  Exception {

    //还原秘钥
    SecretKey secretKey = new SecretKeySpec(key, "HmacSHA1");
    //实力化Mac
    Mac mac = Mac.getInstance(secretKey.getAlgorithm());
    //初始化Mac
    mac.init(secretKey);
    return mac.doFinal(data);
  }

  public static byte[] initHmacSHA224Key() throws Exception {

    //初始化KeyGenerator
    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA224");
    SecretKey secretKey = keyGenerator.generateKey();
    return secretKey.getEncoded();
  }

  public static byte[] initHmacSHA256Key() throws Exception {

    //初始化KeyGenerator
    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
    SecretKey secretKey = keyGenerator.generateKey();
    return secretKey.getEncoded();
  }

  public static byte[] encodeHmacSHA256(byte[] data, byte[] key)
      throws  Exception {

    //还原秘钥
    SecretKey secretKey = new SecretKeySpec(key, "HmacSHA256");
    //实力化Mac
    Mac mac = Mac.getInstance(secretKey.getAlgorithm());
    //初始化Mac
    mac.init(secretKey);
    return mac.doFinal(data);
  }

  public static byte[] initHmacSHA384Key() throws Exception {

    //初始化KeyGenerator
    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA384");
    SecretKey secretKey = keyGenerator.generateKey();
    return secretKey.getEncoded();
  }

  public static byte[] encodeHmacSHA384(byte[] data, byte[] key)
      throws  Exception {

    //还原秘钥
    SecretKey secretKey = new SecretKeySpec(key, "HmacSHA384");
    //实力化Mac
    Mac mac = Mac.getInstance(secretKey.getAlgorithm());
    //初始化Mac
    mac.init(secretKey);
    return mac.doFinal(data);
  }

  public static byte[] initHmacSHA512Key() throws Exception {

    //初始化KeyGenerator
    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA512");
    SecretKey secretKey = keyGenerator.generateKey();
    return secretKey.getEncoded();
  }

  public static byte[] encodeHmacSHA512(byte[] data, byte[] key)
      throws  Exception {

    //还原秘钥
    SecretKey secretKey = new SecretKeySpec(key, "HmacSHA512");
    //实力化Mac
    Mac mac = Mac.getInstance(secretKey.getAlgorithm());
    //初始化Mac
    mac.init(secretKey);
    return mac.doFinal(data);
  }
}
