package com.study.codec.pbe;

import com.study.codec.desede.DESedeCoder;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class TestPBECoder {

  @Test
  public void test() throws Exception {

    String inputStr = "你好,长城";
    byte[] inputData = inputStr.getBytes();
    System.out.println("原文:\t" + inputStr);

    //初始化秘钥
    byte[] salt = PBECoder.initSalt();
    System.out.println("盐:\t" + Base64.encodeBase64String(salt));

    //加密
    String pwd = "H*iw&^asfd;";
    inputData = PBECoder.encrypt(inputData, pwd, salt);
    System.out.println("加密后:\t" +
        Base64.encodeBase64String(inputData));

    //解密
    byte[] outputData = PBECoder.decrypt(inputData, pwd, salt);
    String outputStr = new String(outputData);
    System.out.println("解密后:\t" + outputStr);

    Assert.assertEquals(inputStr, outputStr);
  }
}
