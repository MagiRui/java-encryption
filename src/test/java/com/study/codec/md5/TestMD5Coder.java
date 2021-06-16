package com.study.codec.md5;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class TestMD5Coder {

  @Test
  public final void testEncodeMD5() throws Exception{

    String str = "MD5消息摘要";

    byte[] data1 = MD5Coder.encodeMd5(str);

    byte[] data2 = MD5Coder.encodeMd5(str);

    Assert.assertArrayEquals(data1, data2);
  }

  @Test
  public final void testEncodeMD5Hex() throws Exception {

    String str = "MD5Hex消息摘要";
    String data1 = MD5Coder.encodeMD5Hex(str);
    String data2 = MD5Coder.encodeMD5Hex(str);

    //对同一个消息做MD5Hex处理后,得到的摘要都是32位的十六进制字符串,并且都是一致的
    System.out.println("原文: \t"+ str);
    System.out.println("MD5Hex-1: \t"+ data1);
    System.out.println("MD5Hex-2: \t"+ data2);
    Assert.assertEquals(data1, data2);



  }

}
