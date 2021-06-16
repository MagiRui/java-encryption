package com.study.codec.sha;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public abstract class SHACoder {

  public static byte[] encodeSHA(String data) throws Exception{

    return DigestUtils.sha1(data);
  }

  public static String encodeSHAHex(String data)
  throws Exception {

    return DigestUtils.sha1Hex(data);
  }

  public static byte[] encodeSHA256(String data)
      throws Exception{

    return DigestUtils.sha256(data);
  }

  public static String encodeSHA256Hex(String data)
      throws Exception {

    return DigestUtils.sha256Hex(data);
  }

  public static byte[] encodeSHA384(String data)
      throws Exception{

    return DigestUtils.sha384(data);
  }

  public static String encodeSHA384Hex(String data)
      throws Exception {

    return DigestUtils.sha384Hex(data);
  }

  public static byte[] encodeSHA512(String data)
      throws Exception{

    return DigestUtils.sha512(data);
  }

  public static String encodeSHA512Hex(String data)
      throws Exception {

    return DigestUtils.sha512Hex(data);
  }
}
