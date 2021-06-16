package com.study.codec.basse64;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-03
 */
public class TestBase64Coder {

  @Test
  public void test() throws Exception {

    String inputStr = "13";
    System.out.println("原文:\t" + inputStr);

    String code = Base64Coder.encode(inputStr);
    //非标准方法;加密后会没有\r\n
    System.out.println("编码后:\t" + code);

    String outputStr = Base64Coder.decode(code);
    System.out.println("解码后:\t" + outputStr);

    Assert.assertEquals(inputStr, outputStr);
  }

  @Test
  public void testSafe() throws Exception{

    String inputStr = "Java编程语言";
    System.out.println("原文:\t" + inputStr);

    //标准方法;加密后会有\r\n
    String code = Base64Coder.encodeSafe(inputStr);
    System.out.println("编码后:\t" + code);

    String outputStr = Base64Coder.decode(code);
    System.out.println("解码后:\t" + outputStr);
    Assert.assertEquals(inputStr, outputStr);
  }
}
