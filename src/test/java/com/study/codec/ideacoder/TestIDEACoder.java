package com.study.codec.ideacoder;

import com.study.codec.idea.IDEACoder;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class TestIDEACoder {

  @Test
  public void test() throws Exception {

    String inputStr = "IDEA";
    System.out.println("原文:\t" + inputStr);
    byte[] inputData = inputStr.getBytes();
    byte[] key = IDEACoder.intiKey();
    System.out.println("秘钥:\t" + Base64.encodeBase64String(key));

    inputData = IDEACoder.encrypt(inputData,key);
    System.out.println("加密后:\t" + Base64.encodeBase64String(inputData));

    byte[] outputData = IDEACoder.decrypt(inputData, key);
    String outputStr = new String(outputData);
    System.out.println("解密后:\t" + outputStr);

    Assert.assertEquals(outputStr, inputStr);
  }
}
