package com.study.codec.sha;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class TestSHACoder {

  @Test
  public void testEncodeSHA() throws Exception{

    String str = "SHA1消息摘要";
    byte[] data1 = SHACoder.encodeSHA(str);

    byte[] data2 = SHACoder.encodeSHA(str);

    Assert.assertArrayEquals(data1, data2);
  }

  @Test
  public void testEncodeSHAHex() throws Exception {

    String str = "SHA-1Hex消息摘要";
    String data1 = SHACoder.encodeSHAHex(str);
    String data2 = SHACoder.encodeSHAHex(str);

    System.out.println("原文:\t" + str);
    System.out.println("SHA1Hex-1:\t" + data1);
    System.out.println("SHA1Hex-2:\t" + data2 + "-->" + data2.length());

    Assert.assertEquals(data1, data2);


  }

  @Test
  public void testEncodeSHA256() throws Exception{

    String str = "SHA256消息摘要";
    byte[] data1 = SHACoder.encodeSHA256(str);

    byte[] data2 = SHACoder.encodeSHA256(str);

    Assert.assertArrayEquals(data1, data2);
  }

  @Test
  public void testEncodeSHAHex256() throws Exception {

    String str = "SHA256Hex消息摘要";
    String data1 = SHACoder.encodeSHA256Hex(str);
    String data2 = SHACoder.encodeSHA256Hex(str);

    System.out.println("原文:\t" + str);
    System.out.println("SHA1Hex-1:\t" + data1);
    System.out.println("SHA1Hex-2:\t" + data2 + "-->" + data2.length());

    Assert.assertEquals(data1, data2);
  }

  @Test
  public void testEncodeSHA384() throws Exception{

    String str = "SHA384消息摘要";
    byte[] data1 = SHACoder.encodeSHA384(str);

    byte[] data2 = SHACoder.encodeSHA384(str);

    Assert.assertArrayEquals(data1, data2);
  }

  @Test
  public void testEncodeSHAHex384() throws Exception {

    String str = "SHA384Hex消息摘要";
    String data1 = SHACoder.encodeSHA384Hex(str);
    String data2 = SHACoder.encodeSHA384Hex(str);

    System.out.println("原文:\t" + str);
    System.out.println("SHA1Hex-1:\t" + data1);
    System.out.println("SHA1Hex-2:\t" + data2 + "-->" + data2.length());

    Assert.assertEquals(data1, data2);
  }

  @Test
  public void testEncodeSHA512() throws Exception{

    String str = "SHA512消息摘要";
    byte[] data1 = SHACoder.encodeSHA512(str);

    byte[] data2 = SHACoder.encodeSHA512(str);

    Assert.assertArrayEquals(data1, data2);
  }

  @Test
  public void testEncodeSHAHex512() throws Exception {

    String str = "SHA512Hex消息摘要";
    String data1 = SHACoder.encodeSHA512Hex(str);
    String data2 = SHACoder.encodeSHA512Hex(str);

    System.out.println("原文:\t" + str);
    System.out.println("SHA1Hex-1:\t" + data1);
    System.out.println("SHA1Hex-2:\t" + data2 + "-->" + data2.length());

    Assert.assertEquals(data1, data2);
  }
}
