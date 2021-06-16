package com.study.codec.aes;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class TestBouncyCastleAEScoder {

  @Test
  public void test() throws Exception{

    String inputStr = "AES";
    byte[] inputData = inputStr.getBytes();
    System.out.println("原文:\t" + inputStr);

    //初始化秘钥
    byte[] key = BouncyCastleAESCoder.initKey();
    System.out.println("秘钥:\t" + Base64.encodeBase64String(key));

    //加密
    inputData = BouncyCastleAESCoder.encrypt(inputData, key);
    System.out.println("加密后:\t" +
        Base64.encodeBase64String(inputData));

    //解密
    byte[] outputData = BouncyCastleAESCoder.decrypt(inputData, key);
    String outputStr = new String(outputData);
    System.out.println("解密后:\t" + outputStr);

    Assert.assertEquals(inputStr, outputStr);


  }
}
