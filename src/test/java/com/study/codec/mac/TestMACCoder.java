package com.study.codec.mac;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class TestMACCoder {

  @Test
  public final void testEncodeHmacMD5() throws Exception {

    String str = "HmacMD5消息摘要";
    byte[] key = MACCoder.initHmacMD5Key();
    //获得摘要信息
    byte[] data1 =
        MACCoder.encodeHmacMD5(str.getBytes(), key);
    byte[] data2 =
        MACCoder.encodeHmacMD5(str.getBytes(), key);
    System.out.println(Hex.encodeHex(data1));
    System.out.println(Hex.encodeHex(data2));
    Assert.assertArrayEquals(data1,data2);
  }

  @Test
  public final void testEncodeHmacSHA() throws Exception {

    String str = "HmacSHA1消息摘要";
    byte[] key = MACCoder.initHmacSHAKey();
    //获得摘要信息
    byte[] data1 =
        MACCoder.encodeHmacSHA(str.getBytes(), key);
    byte[] data2 =
        MACCoder.encodeHmacSHA(str.getBytes(), key);

    System.out.println(Hex.encodeHex(data1));
    System.out.println(Hex.encodeHex(data2));
    Assert.assertArrayEquals(data1,data2);
  }

  @Test
  public final void testEncodeHmacSHA256() throws Exception {

    String str = "HmacSHA256消息摘要";
    byte[] key = MACCoder.initHmacSHA256Key();
    //获得摘要信息
    byte[] data1 =
        MACCoder.encodeHmacSHA256(str.getBytes(), key);
    byte[] data2 =
        MACCoder.encodeHmacSHA256(str.getBytes(), key);

    System.out.println(new String(Hex.encodeHex(data1)));
    System.out.println(Hex.encodeHex(data2));
    Assert.assertArrayEquals(data1,data2);
  }
}
