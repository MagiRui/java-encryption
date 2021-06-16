package com.study.codec.rsa;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-07
 */
public abstract class RSACoder {

  //非对称加密秘钥算法
  public static final String KEY_ALGORITHM= "RSA";

  private static final String PUBLIC_KEY = "RSAPublicKey";

  private static final String PRIVATE_KEY= "RSAPrivateKey";

  public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

  /**
   * RSA秘钥长度
   * 默认1024位,
   * 秘钥长度必须是64的倍数
   * 范围在512-65536位之间
   */

  private static final int KEY_SIZE = 512;



  /**
   * @Author MagiRui
   * @Description 签名
   * @Date 11:41 2020-09-07
   * @Params
   * @return
   **/
  public static byte[] sign(byte[] data, byte[] privateKey) throws Exception{

    //转化私钥材料
    PKCS8EncodedKeySpec spec =
        new PKCS8EncodedKeySpec(privateKey);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    PrivateKey priKey = keyFactory.generatePrivate(spec);
    //实例化Signature
    Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
    signature.initSign(priKey);
    signature.update(data);
    return signature.sign();
  }


  /**
   * @Author MagiRui
   * @Description 校验
   * @Date 11:49 2020-09-07
   * @Params
   * @return
   **/
  public static boolean verify(byte[] data, byte[] publicKey, byte[] sign)
    throws Exception {

    //转化公钥材料
    X509EncodedKeySpec spec =
        new X509EncodedKeySpec(publicKey);
    //实例化秘钥工厂
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

    //生成公钥
    PublicKey pubKey = keyFactory.generatePublic(spec);
    //实例化Signature
    Signature sinature = Signature.getInstance(SIGNATURE_ALGORITHM);
    //初始化Signature
    sinature.initVerify(pubKey);
    sinature.update(data);
    return sinature.verify(sign);
  }


  /**
   * 私钥解密
   * @param data
   * @param key
   * @return
   * @throws Exception
   */
  public static byte[] decryptByPrivateKey(
      byte[] data, byte[] key) throws Exception{

    PKCS8EncodedKeySpec pkcs8EncodedKeySpec =
        new PKCS8EncodedKeySpec(key);
    KeyFactory keyFactory =
        KeyFactory.getInstance(KEY_ALGORITHM);
    //生成私钥
    PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

    //对数据解密
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    return cipher.doFinal(data);
  }


  /**
   * @Author MagiRui
   * @Description 公钥解密
   * @Date 10:17 2020-09-07
   * @Params
   * @return
   **/
  public static byte[] decryptByPublicKey(
      byte[] data, byte[] key) throws Exception {

    X509EncodedKeySpec x509EncodedKeySpec =
        new X509EncodedKeySpec(key);
    KeyFactory keyFactory =
        KeyFactory.getInstance(KEY_ALGORITHM);

    //生成公钥
    PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(Cipher.DECRYPT_MODE, publicKey);
    return cipher.doFinal(data);
  }


  /**
   * @Author MagiRui
   * @Description 公钥加密
   * @Date 10:20 2020-09-07
   * @Params
   * @return
   **/
  public static byte[] encryptByPubicKey(byte[] data,
      byte[] key) throws Exception{

    X509EncodedKeySpec x509EncodedKeySpec =
        new X509EncodedKeySpec(key);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
    return cipher.doFinal(data);
  }


  /**
   * @Author MagiRui
   * @Description 私钥加密
   * @Date 10:23 2020-09-07
   * @Params
   * @return
   **/
  public static byte[] encryptByPrivateKey(byte[] data, byte[] key)
    throws Exception {

    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    PrivateKey privateKey = keyFactory.generatePrivate(spec);
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(Cipher.ENCRYPT_MODE, privateKey);
    return cipher.doFinal(data);
  }

  
  /**
   * @Author MagiRui
   * @Description 取得私钥
   * @Date 10:27 2020-09-07
   * @Params 
   * @return 
   **/
  public static byte[] getPrivateKey(Map<String, Object> keyMap)
    throws Exception {

    Key key = (Key) keyMap.get(PRIVATE_KEY);
    return key.getEncoded();
  }


  /**
   * @Author MagiRui
   * @Description 取得公钥
   * @Date 10:29 2020-09-07
   * @Params
   * @return
   **/
  public static byte[] getPublicKey(Map<String, Object> keyMap)
      throws Exception {

    Key key = (Key) keyMap.get(PUBLIC_KEY);
    return key.getEncoded();
  }


  /**
   * @Author MagiRui
   * @Description 初始化秘钥
   * @Date 10:30 2020-09-07
   * @Params
   * @return
   **/
  public static Map<String, Object> initKey() throws Exception {

    //实例化秘钥生成器
    KeyPairGenerator keyPairGene =
        KeyPairGenerator.getInstance(KEY_ALGORITHM);
    //初始化秘钥对生成器
    keyPairGene.initialize(KEY_SIZE);
    //生成秘钥对
    KeyPair keyPair = keyPairGene.generateKeyPair();
    //公钥
    RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
    //私钥
    RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
    //封装秘钥
    Map<String, Object> pairKey = new HashMap<String, Object>(2);

    pairKey.put(PUBLIC_KEY, publicKey);
    pairKey.put(PRIVATE_KEY, privateKey);
    return pairKey;
  }

}
