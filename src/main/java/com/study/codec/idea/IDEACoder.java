package com.study.codec.idea;

import java.security.Key;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class IDEACoder {

  public static final String KEY_ALGORITHM = "IDEA";

  public static final String CIPHER_ALGORITHM="IDEA/ECB/ISO10126Padding";

  private static Key toKey(byte[] key) throws Exception {

    SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
    return secretKey;
  }

  public static byte[] decrypt(byte[] data, byte[] key) throws Exception{

    Security.addProvider(new BouncyCastleProvider());
    Key k = toKey(key);
    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, k);
    return cipher.doFinal(data);
  }

  public static byte[] encrypt(byte[] data, byte[] key) throws Exception{

    Security.addProvider(new BouncyCastleProvider());
    Key k = toKey(key);
    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, k);
    return cipher.doFinal(data);
  }

  public static byte[] intiKey() throws Exception {

    Security.addProvider(new BouncyCastleProvider());
    KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
    kg.init(128);
    SecretKey secretKey = kg.generateKey();
    return secretKey.getEncoded();

  }
}
