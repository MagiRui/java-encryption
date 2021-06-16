package com.study.codec.basse64;


import org.apache.commons.codec.binary.Base64;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-03
 */
public abstract class Base64Coder {

  public final static String ENCODING="UTF-8";

  public static String encode(String data) throws Exception {

    byte[] b = Base64.encodeBase64(data.getBytes(ENCODING));
    return new String(b, ENCODING);
  }

  public static String encodeSafe(String data) throws Exception{

    byte[] b = Base64.encodeBase64(data.getBytes(ENCODING), true);
    return new String(b, ENCODING);
  }

  public static String decode(String data) throws Exception {

    byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));
    return new String(b, ENCODING);
  }
}
