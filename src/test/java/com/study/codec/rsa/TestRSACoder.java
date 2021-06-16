package com.study.codec.rsa;

import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-07
 */
public class TestRSACoder {

  private byte[] publicKey;

  private byte[] privateKey;

  @Before
  public void initKey() throws Exception {

    Map<String, Object>
        keyMap = RSACoder.initKey();

    publicKey = RSACoder.getPublicKey(keyMap);

    privateKey = RSACoder.getPrivateKey(keyMap);

    System.out.println("公钥:\n" +
        Base64.encodeBase64String(publicKey));

    System.out.println("私钥:\n" +
        Base64.encodeBase64String(privateKey));
  }

  @Test
  public void test1() throws Exception {

    System.out.println("\n---私钥加密-公钥解密---");
    String inputStr1 = "RSA加密算法";
    byte[] data1 = inputStr1.getBytes();
    System.out.println("原文:\n" + inputStr1);

    //加密
    byte[] encodeData1 = RSACoder.encryptByPrivateKey(data1, privateKey);
    System.out.println("加密后:\n" + Base64.encodeBase64String(encodeData1));

    //解密
    byte[] decodeData1 = RSACoder.decryptByPublicKey(encodeData1, publicKey);
    String outputStr1 = new String(decodeData1);
    System.out.println("解密后:\n" + outputStr1);
    Assert.assertEquals(inputStr1, outputStr1);

  }


  @Test
  public void test2() throws Exception {

    System.out.println("\n---公钥加密-私钥解密---");
    String inputStr1 = "RSA加密算法";
    byte[] data1 = inputStr1.getBytes();
    System.out.println("原文:\n" + inputStr1);

    //加密
    byte[] encodeData1 = RSACoder.encryptByPubicKey(data1, publicKey);
    System.out.println("加密后:\n" + Base64.encodeBase64String(encodeData1));

    //解密
    byte[] decodeData1 = RSACoder.decryptByPrivateKey(encodeData1, privateKey);
    String outputStr1 = new String(decodeData1);
    System.out.println("解密后:\n" + outputStr1);
    Assert.assertEquals(inputStr1, outputStr1);

  }

  @Test
  public void testSign() throws Exception{

    String inputStr = "RSA数字签名";
    byte[] data = inputStr.getBytes();
    //产生签名
    byte[] sign = RSACoder.sign(data, privateKey);
    System.out.println("签名:\n" + Hex.encodeHexString(sign));

    boolean status = RSACoder.verify(data, publicKey, sign);
    Assert.assertTrue(status);
  }

}
