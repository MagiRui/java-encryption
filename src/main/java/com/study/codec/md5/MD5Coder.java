package com.study.codec.md5;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public abstract class MD5Coder {

  public static byte[] encodeMd5(String data)
    throws Exception {

    return DigestUtils.md5(data);
  }

  public static String encodeMD5Hex(String data)
  throws Exception{
    return DigestUtils.md5Hex(data);
  }

}
