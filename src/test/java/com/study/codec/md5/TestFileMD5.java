package com.study.codec.md5;

import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;
import sun.plugin2.message.Message;

/**
 * @author MagiRui
 * @description
 * @date 2020-09-04
 */
public class TestFileMD5 {

  @Test
  public void testMyMessageDigest() throws Exception{

    String path = "/Users/magirui/java-encryption/src/test/java/com/study/codec/md5/testFile.txt";
    FileInputStream fis = new FileInputStream(new File(path));
    DigestInputStream dis =
        new DigestInputStream(fis,
            MessageDigest.getInstance("MD5"));
    int buf = 1024;
    byte[] buffer = new byte[buf];
    int read = dis.read(buffer, 0, buf);
    while(read > -1) {

      read = dis.read(buffer, 0, buf);
    }

    dis.close();
    MessageDigest md = dis.getMessageDigest();
    byte[] b = md.digest();
    String md5Hex = Hex.encodeHexString(b);
    Assert.assertEquals("36da387f060a60873045c1fda395a1e2", md5Hex);

  }

  @Test
  public void testByDigestUtils()throws Exception{

    String path = "/Users/magirui/java-encryption/src/test/java/com/study/codec/md5/testFile.txt";
    FileInputStream fis = new FileInputStream(new File(path));
    String md5Hex = DigestUtils.md5Hex(fis);
    fis.close();
    Assert.assertEquals("36da387f060a60873045c1fda395a1e2", md5Hex);


  }
}
