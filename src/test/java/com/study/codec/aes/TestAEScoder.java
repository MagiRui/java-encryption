package com.study.codec.aes;

import com.study.codec.des.DESCoder;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class TestAEScoder {

  @Test
  public void test() throws Exception{

    String inputStr = "AES";
    byte[] inputData = inputStr.getBytes();
    System.out.println("原文:\t" + inputStr);

    //初始化秘钥
    byte[] key = AESCoder.initKey();
    System.out.println("秘钥:\t" + Base64.encodeBase64String(key));

    //加密
    inputData = AESCoder.encrypt(inputData, key);
    System.out.println("加密后:\t" +
        Base64.encodeBase64String(inputData));

    //解密
    byte[] outputData = AESCoder.decrypt(inputData, key);
    String outputStr = new String(outputData);
    System.out.println("解密后:\t" + outputStr);

    Assert.assertEquals(inputStr, outputStr);


  }
}
